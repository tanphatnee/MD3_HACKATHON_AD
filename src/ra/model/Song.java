package ra.model;

import java.util.Date;
import java.util.Scanner;

import ra.service.SingerService;

public class Song {
    private static int counter = 0;

    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        this.songId = generateSongId();
        this.createdDate = new Date();
    }

    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    private String generateSongId() {
        counter++;
        return "S" + String.format("%03d", counter);
    }

    public void inputData() {
    }

    public void inputData(SingerService singerService, Song song) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập thông tin bài hát: ");
        System.out.print("Tên bài hát: ");
        songName = scanner.nextLine();
        System.out.print("Mô tả: ");
        descriptions = scanner.nextLine();
        System.out.println("Chọn ca sĩ: ");

        System.out.println("Danh sách ca sĩ: ");
        for (Singer singer : singerService.getAllSingers()) {
            System.out.println("ID: " + singer.getSingerId() + ", Tên ca sĩ: " + singer.getSingerName());
        }

        System.out.print("Chọn ca sĩ bằng cách nhập ID: ");
        String singerId = scanner.nextLine();

        Singer selectedSinger = singerService.findSingerById(Integer.parseInt(singerId));
        if (selectedSinger != null) {
            song.setSinger(selectedSinger);
            System.out.println("Ca sĩ đã được chọn: " + selectedSinger.getSingerName());
        } else {
            System.out.println("Không tìm thấy ca sĩ.");
        }

        System.out.print("Nhạc sĩ: ");
        songWriter = scanner.nextLine();
    }


    public void displayData() {
        System.out.println("Thông tin bài hát:");
        System.out.println("ID bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Ca sĩ: " + singer.getSingerName());
        System.out.println("Nhạc sĩ: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái bài hát: " + (songStatus ? "Hoạt động" : "Không hoạt động"));
    }
}