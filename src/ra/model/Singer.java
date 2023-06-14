package ra.model;

import java.util.Scanner;

public class Singer {
    private static int counter = 0;

    private final int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        this.singerId = ++counter;
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập thông tin ca sĩ: ");
        System.out.print("Tên ca sĩ: ");
        singerName = scanner.nextLine();
        System.out.print("Tuổi: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.print("Quốc tịch: ");
        nationality = scanner.nextLine();
        System.out.print("Giới tính (true - Nam hoặc false - Nữ): ");
        gender = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Thể loại nhạc: ");
        genre = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Thông tin ca sĩ:");
        System.out.println("ID ca sĩ: " + singerId);
        System.out.println("Tên ca sĩ: " + singerName);
        System.out.println("Tuổi: " + age);
        System.out.println("Quốc tịch: " + nationality);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Thể loại nhạc: " + genre);
    }
}