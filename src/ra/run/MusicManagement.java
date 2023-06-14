package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class MusicManagement {
    private SingerController singerController;
    private SongController songController;

    public MusicManagement() {
        SingerService singerService = new SingerService();
        SongService songService = new SongService();

        singerController = new SingerController(singerService);
        songController = new SongController(songService);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ.");
            System.out.println("2. Quản lý bài hát.");
            System.out.println("3. Tìm kiếm bài hát.");
            System.out.println("4. Thoát!");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("**********************SINGER-MANAGEMENT*************************");
                    System.out.println("1. Thêm mới ca sĩ.");
                    System.out.println("2. Hiển thị danh sách tất cả ca sĩ.");
                    System.out.println("3. Thay đổi thông tin ca sĩ theo mã id.");
                    System.out.println("4. Xóa ca sĩ theo mã id.");
                    System.out.println("5. Thoát!");
                    int singerChoice = Integer.parseInt(scanner.nextLine());

                    switch (singerChoice) {
                        case 1:
                            singerController.addSinger();
                            break;
                        case 2:
                            singerController.displayAllSingers();
                            break;
                        case 3:
                            singerController.updateSinger();
                            break;
                        case 4:
                            singerController.deleteSinger();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("**********************SONG-MANAGEMENT*************************");
                    System.out.println("1. Thêm mới bài hát.");
                    System.out.println("2. Hiển thị danh sách bài hát.");
                    System.out.println("3. Thay đổi thông tin bài hát theo id.");
                    System.out.println("4. Xóa bài hát theo id.");
                    System.out.println("5. Thoát!");
                    int songChoice = Integer.parseInt(scanner.nextLine());

                    switch (songChoice) {
                        case 1:
                            songController.addSong();
                            break;
                        case 2:
                            songController.displayAllSongs();
                            break;
                        case 3:
                            songController.updateSong();
                            break;
                        case 4:
                            songController.deleteSong();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                            break;
                    }

                    break;
                case 3:
                    System.out.println("*********************SEARCH-MANAGEMENT************************");
                    System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại.");
                    System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại.");
                    System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần.");
                    System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất.");
                    System.out.println("5. Thoát!");
                    int searchChoice = Integer.parseInt(scanner.nextLine());

                    switch (searchChoice) {
                        case 1:
                            singerController.searchSingersByName();
                            break;
                        case 2:
                            songController.searchSongsByName();
                            break;
                        case 3:
                            songController.displaySongsByNameAscending();
                            break;
                        case 4:
                            songController.displayNewestSongs();
                            break;
                        case 5:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Thoát!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        MusicManagement musicManagement = new MusicManagement();
        musicManagement.start();
    }
}
