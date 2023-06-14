package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

import java.util.List;
import java.util.Scanner;

public class SingerController {
    private SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    public void addSinger() {
        Singer singer = new Singer();
        singer.inputData();

        if (singer.getSingerName().isEmpty()) {
            System.out.println("Tên ca sĩ không được bỏ trống. Vui lòng thử lại. ");
            return;
        }

        singerService.addSinger(singer);
        System.out.println("Thêm Ca Sĩ Thành Công. ");
    }


    public void displayAllSingers() {
        System.out.println("Danh sách tất cả các ca sĩ: ");
        for (Singer singer : singerService.getAllSingers()) {
            singer.displayData();
            System.out.println("---------------------------------");
        }
    }

    public void updateSinger() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID của ca sĩ cần cập nhật: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        Singer singer = singerService.findSingerById(singerId);
        if (singer != null) {
            singer.inputData();
            singerService.updateSinger(singer);
            System.out.println("Ca sĩ đã được cập nhật thành công. ");
        } else {
            System.out.println("Không tìm thấy ca sĩ. ");
        }
    }

    public void deleteSinger() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID ca sĩ muốn xóa: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        Singer singer = singerService.findSingerById(singerId);
        if (singer != null) {
            singerService.deleteSinger(singerId);
            System.out.println("Xóa ca sĩ thành công. ");
        } else {
            System.out.println("Không tìm thấy ca sĩ. ");
        }
    }

    public void searchSingersByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên ca sĩ: ");
        String keyword = scanner.nextLine();

        List<Singer> searchResults = singerService.searchSingersByName(keyword);
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy ca sĩ nào có tên chứa từ khóa: " + keyword);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Singer singer : searchResults) {
                System.out.println("Mã ID: " + singer.getSingerId());
                System.out.println("Tên ca sĩ: " + singer.getSingerName());
                System.out.println("Tuổi: " + singer.getAge());
                System.out.println("Quốc tịch: " + singer.getNationality());
                System.out.println("*********************************");
            }
        }
    }


}