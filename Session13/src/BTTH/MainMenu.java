package BTTH;

import java.util.Scanner;

public class MainMenu {
    private static PatientManager manager = new PatientManager();
    private static Scanner sc = new Scanner(System.in);

    public static void handleMenuSelection() {
        int choice;
        do {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ BỆNH NHÂN =====");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Xóa bệnh nhân");
            System.out.println("3. Cập nhật thông tin");
            System.out.println("4. Tìm kiếm theo tên");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Kết thúc");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập ID: "); int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Tên: "); String name = sc.nextLine();
                    System.out.print("Tuổi: "); int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Giới tính: "); String gender = sc.nextLine();
                    System.out.print("Bệnh lý: "); String diag = sc.nextLine();
                    manager.addPatient(new Patient(id, name, age, gender, diag));
                }
                case 2 -> {
                    System.out.print("Nhập ID cần xóa: ");
                    manager.removePatient(Integer.parseInt(sc.nextLine()));
                }
                case 3 -> {
                    System.out.print("Nhập ID cần cập nhật: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Tên mới: "); String name = sc.nextLine();
                    System.out.print("Tuổi mới: "); int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Giới tính mới: "); String gender = sc.nextLine();
                    System.out.print("Bệnh lý mới: "); String diag = sc.nextLine();
                    manager.updatePatient(id, new Patient(id, name, age, gender, diag));
                }
                case 4 -> {
                    System.out.print("Nhập tên tìm kiếm: ");
                    manager.searchPatientByName(sc.nextLine());
                }
                case 5 -> manager.displayPatients();
                case 6 -> System.out.println("Chương trình kết thúc. Tạm biệt Lợi!");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        handleMenuSelection();
    }
}
