package HN_KS24_CNTT2_TrieuQuocBinh;

import java.util.Scanner;

public class Main {
    static Student[] students;
    static int n;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo Học lực");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát");
            System.out.println("==================================");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    searchByRank();
                    break;
                case 4:
                    sortByScoreDesc();
                    System.out.println("Đã sắp xếp xong!");
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Chọn sai chức năng!");
            }
        } while (choice != 5);
    }

    // Chức năng 1
    static void inputStudents() {
        System.out.print("Nhập số lượng sinh viên: ");
        n = sc.nextInt();
        sc.nextLine();

        students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));

            String id;
            do {
                System.out.print("Nhập ID (SVxxx): ");
                id = sc.nextLine();

                if (!isValidId(id)) {
                    System.out.println("ID sai định dạng!");
                } else if (isDuplicateId(id, students, i)) {
                    System.out.println("ID đã tồn tại, nhập lại!");
                }

            } while (!isValidId(id) || isDuplicateId(id, students, i));


            System.out.print("Nhập tên: ");
            String name = sc.nextLine();

            System.out.print("Nhập điểm: ");
            double score = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(id, name, score);
        }
    }

    // Validate ID
    static boolean isValidId(String id) {
        if (!id.startsWith("SV") || id.length() != 5) {
            return false;
        }
        for (int i = 2; i < 5; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isDuplicateId(String id, Student[] students, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }


    // Chức năng 2
    static void showStudents() {
        if (students == null) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Chức năng 3
    static void searchByRank() {
        if (students == null) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        System.out.print("Nhập học lực cần tìm (Gioi/Kha/Trung Binh): ");
        String rank = sc.nextLine();

        boolean found = false;
        for (Student s : students) {
            if (s.getRank().equalsIgnoreCase(rank)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên phù hợp!");
        }
    }

    // Chức năng 4
    static void sortByScoreDesc() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}

