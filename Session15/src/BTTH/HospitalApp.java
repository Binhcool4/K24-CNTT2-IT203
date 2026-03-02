package BTTH;
import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ BỆNH VIỆN =========");
            System.out.println("1. Đăng ký khám (Create Queue)");
            System.out.println("2. Gọi khám bệnh (Update Stack)");
            System.out.println("3. Xem danh sách chờ (Read Queue)");
            System.out.println("4. Tìm kiếm bệnh nhân");
            System.out.println("5. Xem lịch sử điều trị (LIFO Stack)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Tên: "); String name = sc.nextLine();
                    System.out.print("Tuổi: "); int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Cấp cứu? (y/n): ");
                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        System.out.print("Mức ưu tiên (1-3): ");
                        int level = Integer.parseInt(sc.nextLine());
                        service.add(new EmergencyPatient(id, name, age, "Cấp cứu", level));
                    } else {
                        service.add(new Patient(id, name, age, "Bình thường"));
                    }
                    break;
                case 2:
                    System.out.print("Nhập chẩn đoán/thuốc: ");
                    service.callNextPatient(sc.nextLine());
                    break;
                case 3:
                    service.display();
                    break;
                case 5:
                    System.out.print("Nhập ID bệnh nhân: ");
                    Patient p = service.search(sc.nextLine());
                    service.showPatientHistory(p);
                    break;
            }
        } while (choice != 0);
    }
}