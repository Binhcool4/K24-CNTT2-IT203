import java.util.Scanner;
import java.util.regex.Pattern;

public class HN_KS24_CNTT_TrieuQuocBinh {
    static final int max = 100;
    static String[] mssvList = new String[max];
    static int count = 0;

    static final String MSSV_REGEX = "^B\\d{7}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU QUẢN LÝ MSSV =====");
            System.out.println("1. Hiển thị danh sách MSSV");
            System.out.println("2. Thêm MSSV mới");
            System.out.println("3. Cập nhật MSSV theo index");
            System.out.println("4. Xóa MSSV");
            System.out.println("5. Tìm kiếm MSSV (Regex)");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    hienThi();
                    break;
                case 2:
                    them(scanner);
                    break;
                case 3:
                    capNhat(scanner);
                    break;
                case 4:
                    xoa(scanner);
                    break;
                case 5:
                    timKiem(scanner);
                    break;
                case 6:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    // 1. Hiển thị
    static void hienThi() {
        if (count == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("Danh sách MSSV:");
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + mssvList[i]);
        }
    }

    // 2. Thêm mới (Regex)
    static void them(Scanner scanner) {
        if (count >= max) {
            System.out.println("Danh sách đã đầy!");
            return;
        }

        String mssv;
        do {
            System.out.print("Nhập MSSV mới: ");
            mssv = scanner.nextLine();
        } while (!Pattern.matches(MSSV_REGEX, mssv));

        mssvList[count++] = mssv;
        System.out.println("Thêm MSSV thành công!");
    }

    // 3. Cập nhật
    static void capNhat(Scanner scanner) {
        System.out.print("Nhập index cần sửa: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= count) {
            System.out.println("Index không hợp lệ!");
            return;
        }

        String newMssv;
        do {
            System.out.print("Nhập MSSV mới: ");
            newMssv = scanner.nextLine();
        } while (!Pattern.matches(MSSV_REGEX, newMssv));

        mssvList[index] = newMssv;
        System.out.println("Cập nhật thành công!");
    }

    // 4. Xóa
    static void xoa(Scanner scanner) {
        System.out.print("Nhập MSSV cần xóa: ");
        String mssv = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].equalsIgnoreCase(mssv)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Không tìm thấy MSSV!");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            mssvList[i] = mssvList[i + 1];
        }
        count--;
        System.out.println("Xóa thành công!");
    }

    // 5. Tìm kiếm (Regex - không phân biệt hoa thường)
    static void timKiem(Scanner scanner) {
        System.out.print("Nhập chuỗi cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (mssvList[i].toLowerCase().contains(keyword)) {
                System.out.println(i + ": " + mssvList[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có MSSV phù hợp!");
        }
    }
}
