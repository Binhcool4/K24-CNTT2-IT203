package BTTH;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        PatientService service = new PatientService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= QUẢN LÝ PHÒNG KHÁM =========");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Cập nhật bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("5. Thêm hồ sơ khám");
            System.out.println("6. Xem hồ sơ bệnh nhân");
            System.out.println("7. Xóa hồ sơ khám");
            System.out.println("8. Tìm bệnh nhân");
            System.out.println("9. Sắp xếp bệnh nhân");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Mã BN: "); String id = sc.nextLine();
                        System.out.print("Tên: "); String name = sc.nextLine();
                        System.out.print("Tuổi: "); int age = Integer.parseInt(sc.nextLine());
                        System.out.print("SĐT: "); String phone = sc.nextLine();
                        service.add(new Patient(id, name, age, phone));
                        break;
                    case 2:
                        System.out.print("Nhập mã BN cần sửa: ");
                        service.update(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập mã BN cần xóa: ");
                        service.delete(sc.nextLine());
                        break;
                    case 4:
                        service.displayAll();
                        break;
                    case 5:
                        System.out.print("Nhập mã BN: "); String pid = sc.nextLine();
                        System.out.print("Mã hồ sơ: "); String rid = sc.nextLine();
                        System.out.print("Chẩn đoán: "); String diag = sc.nextLine();
                        System.out.print("Ngày (dd/mm/yyyy): "); String date = sc.nextLine();
                        service.addRecord(pid, new MedicalRecord(rid, diag, date));
                        break;
                    case 6:
                        System.out.print("Nhập mã BN để xem hồ sơ: ");
                        service.viewRecords(sc.nextLine());
                        break;
                    case 7:
                        System.out.print("Nhập mã BN: "); String pIdDel = sc.nextLine();
                        System.out.print("Nhập mã hồ sơ cần xóa: "); String rIdDel = sc.nextLine();
                        service.deleteRecord(pIdDel, rIdDel);
                        break;
                    case 8: // Tìm kiếm
                        System.out.print("Nhập mã bệnh nhân cần tìm: ");
                        String searchId = sc.nextLine();
                        Patient foundPatient = service.findById(searchId);

                        if (foundPatient != null) {
                            System.out.println("Kết quả tìm kiếm:");
                            foundPatient.displayInfo();
                        } else {
                            System.out.println("Không tìm thấy bệnh nhân có mã: " + searchId);
                        }
                        break;
                    case 9: // Sắp xếp
                        System.out.println("1. Mặc định (Tên) | 2. Theo Tuổi | 3. Theo ID");
                        int sortType = Integer.parseInt(sc.nextLine());
                        service.sortPatients(sortType);
                        break;
                    case 0:
                        System.out.println("Tạm biệt Lợi!");
                        break;
                    default:
                        System.out.println("Chức năng không tồn tại!");
            }
        } while (choice != 0);
    }
}
