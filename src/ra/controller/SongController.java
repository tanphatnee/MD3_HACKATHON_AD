package ra.controller;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SongService;
import ra.service.SingerService;

import java.util.List;
import java.util.Scanner;

public class SongController {
    private SongService songService;
    private SingerService singerService;

    public SongController(SongService songService) {
        this.songService = songService;
        this.singerService = new SingerService();
    }

    public SongController(SongService songService, SingerService singerService) {
        this.songService = songService;
        this.singerService = singerService;
    }

    public void addSong() {
        Song song = new Song();
        song.inputData();

        if (song.getSinger() == null) {
            System.out.println("Không tìm thấy ca sĩ nào. Vui lòng thêm một ca sĩ trước. ");
            Singer newSinger = new Singer();
            newSinger.inputData();
            singerService.addSinger(newSinger);
            song.setSinger(newSinger);
        }

        songService.addSong(song);
        System.out.println("Thêm bài hát thành công. ");
    }

    public void displayAllSongs() {
        System.out.println("Danh sách tất cả bài hát: ");
        for (Song song : songService.getAllSongs()) {
            song.displayData();
            System.out.println("---------------------------------");
        }
    }

    public void updateSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID bài hát muốn cập nhật: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            song.inputData();
            songService.updateSong(song);
            System.out.println("Cập nhật bài hát thành công.");
        } else {
            System.out.println("Không tìm thấy bài hát.");
        }
    }

    public void deleteSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập id bài hát muốn xóa: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            songService.deleteSong(songId);
            System.out.println("Xóa bài hát thành công.");
        } else {
            System.out.println("Không tìm thấy bài hát.");
        }
    }

    public void searchSongsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên bài hát: ");
        String keyword = scanner.nextLine();

        List<Song> searchResults = songService.searchSongsByName(keyword);
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy bài hát nào có tên chứa từ khóa: " + keyword);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Song song : searchResults) {
                System.out.println("Mã ID: " + song.getSongId());
                System.out.println("Tên bài hát: " + song.getSongName());
                System.out.println("Ca sĩ: " + song.getSinger().getSingerName());
                System.out.println("---------------------------------");
            }
        }
    }

    public void displaySongsByNameAscending() {
        List<Song> sortedSongs = songService.getSongsByNameAscending();
        if (sortedSongs.isEmpty()) {
            System.out.println("Danh sách bài hát trống.");
        } else {
            System.out.println("Danh sách bài hát theo thứ tự tăng dần theo tên:");
            for (Song song : sortedSongs) {
                System.out.println("Mã ID: " + song.getSongId());
                System.out.println("Tên bài hát: " + song.getSongName());
                System.out.println("---------------------------------");
            }
        }
    }

    public void displayNewestSongs() {
        List<Song> newestSongs = songService.getNewestSongs();
        if (newestSongs.isEmpty()) {
            System.out.println("Danh sách bài hát trống.");
        } else {
            System.out.println("Danh sách " + newestSongs.size() + " bài hát mới nhất:");
            for (Song song : newestSongs) {
                System.out.println("Mã ID: " + song.getSongId());
                System.out.println("Tên bài hát: " + song.getSongName());
                System.out.println("---------------------------------");
            }
        }
    }
}
