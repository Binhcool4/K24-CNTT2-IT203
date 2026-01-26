import java.util.Scanner;

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ THƯ VIỆN =========");
            System.out.println("1. Tính tiền phạt trả sách");
            System.out.println("2. Đăng ký thẻ VIP");
            System.out.println("3. Thống kê nhập kho");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-3): ");

            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    calculateFine(sc);
                    break;
                case 2:
                    vipRegister(sc);
                    break;
                case 3:
                    inventoryStatistics(sc);
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng hệ thống. Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    public static void calculateFine(Scanner sc) {
        System.out.print("Nhập số lượng sách trả:");
        int m = Integer.parseInt(sc.nextLine());
        long totalFine = 0;

        for(int i = 1; i <= m; i++) {
            System.out.print("Nhập số ngày quá hạn cuôn sách " + i + ": ");
            int n = Integer.parseInt(sc.nextLine());

            if(n <= 5) {
                totalFine += n * 2000;
            } else {
                totalFine += (5 * 2000) + (n - 5) * 5000;
            }
        }

        System.out.println("Tổng tiền phạt là " + totalFine);
    }

    public static void vipRegister(Scanner sc) {
        System.out.print("Nhập tuổi của bạn: ");
        int tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Số sách đã mượn tháng qua: ");
        int soSach = Integer.parseInt(sc.nextLine());
        System.out.print("Bạn có thẻ ưu tiên không? (1: Có, 0: Không): ");
        int theUuTien = Integer.parseInt(sc.nextLine());

        boolean laVIP = (tuoi >= 18 && soSach >= 10) || (theUuTien == 1);

        if (laVIP) {
            System.out.println("Đủ tiêu chuẩn nâng cấp VIP!");
        } else {
            System.out.println("Chưa đủ tiêu chuẩn.");
        }
    }


    public static void inventoryStatistics(Scanner sc) {
        int count = 0;
        System.out.println("Nhập mã số sách mới (Nhập 0 để kết thúc, số âm để nhập lại)");

        do {
            System.out.print("Mã số sách: ");
            int maSo = Integer.parseInt(sc.nextLine());

            if (maSo == 0) {
                break;
            }
            if (maSo < 0) {
                System.out.println("Mã sách không được âm");
                continue;
            }

            count++;
        } while (true);

        System.out.println("Đã nhập kho thành công " + count + " cuốn sách.");
    }
}

