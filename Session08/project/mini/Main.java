package project.mini;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(100);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm kiếm");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Mã SV: ");
                    String id = sc.nextLine();
                    System.out.print("Họ tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Giới tính: ");
                    String gender = sc.nextLine();
                    System.out.print("Toán: ");
                    double m = Double.parseDouble(sc.nextLine());
                    System.out.print("Lý: ");
                    double p = Double.parseDouble(sc.nextLine());
                    System.out.print("Hóa: ");
                    double c = Double.parseDouble(sc.nextLine());

                    if (manager.addStudent(new Student(id, name, age, gender, m, p, c)))
                        System.out.println("Thêm thành công!");
                    else
                        System.out.println("Thêm thất bại!");
                    break;

                case 2:
                    manager.displayAll();
                    break;

                case 3:
                    System.out.print("Nhập tên cần tìm: ");
                    manager.searchByName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Nhập mã SV cần xóa: ");
                    if (manager.delete(sc.nextLine()))
                        System.out.println("Đã xóa!");
                    else
                        System.out.println("Không tìm thấy!");
                    break;

                case 5:
                    int choose = Integer.parseInt(sc.nextLine());
                    do{
                        System.out.println("1. Sắp xếp theo tên A-Z");
                        System.out.println("2. Sắp xếp điểm giảm dần");
                        System.out.print("Chọn: ");
                        switch (choose){
                            case 1:
                                manager.sortByNameAZ();
                                System.out.println("Đã sắp xếp!");
                                break;
                            case 2:
                                manager.sortByAvgDesc();
                                System.out.println("Đã sắp xếp!");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                                break;
                        }
                    } while (choose < 1 || choose > 2);
                    System.out.println("Đã sắp xếp!");
                    break;

                case 6:
                    manager.statistic();
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                    break;
            }

        } while (choice != 0);

        System.out.println("Thoát chương trình!");
    }
}
