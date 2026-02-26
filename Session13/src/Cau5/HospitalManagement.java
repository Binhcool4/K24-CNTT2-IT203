package Cau5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HospitalManagement {
    private static List<Patient> patientList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n||==========================MENU==========================||");
            System.out.println("||              1. Tiếp nhận bệnh nhân                    ||");
            System.out.println("||              2. Cập nhật chẩn đoán                     ||");
            System.out.println("||              3. Xuất viện                              ||");
            System.out.println("||              4. Sắp xếp danh sách bệnh nhân            ||");
            System.out.println("||              5. Hiển thị danh sách bệnh nhân           ||");
            System.out.println("||              6. Thoát                                  ||");
            System.out.println("||========================================================||");

            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> updateDiagnosis();
                case 3 -> dischargePatient();
                case 4 -> sortPatients();
                case 5 -> displayPatients();
                case 6 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private static void addPatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.println("Lỗi: ID bệnh nhân đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân để cập nhật chẩn đoán: ");
        String id = sc.nextLine();
        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                p.setDiagnosis(sc.nextLine());
                System.out.println("Chẩn đoán đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân có ID: " + id);
    }

    private static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân để xuất viện: ");
        String id = sc.nextLine();
        boolean removed = patientList.removeIf(p -> p.getId().equals(id));
        if (removed) {
            System.out.println("Bệnh nhân đã xuất viện thành công.");
        } else {
            System.out.println("Không tìm thấy bệnh nhân!");
        }
    }

    private static void sortPatients() {
        patientList.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                int ageCompare = Integer.compare(p2.getAge(), p1.getAge());
                if (ageCompare != 0) {
                    return ageCompare;
                }
                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });
        System.out.println("Danh sách bệnh nhân đã được sắp xếp.");
    }

    private static void displayPatients() {
        System.out.println("====================Danh sách bệnh nhân====================");
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Patient p : patientList) System.out.println(p);
        }
    }
}
