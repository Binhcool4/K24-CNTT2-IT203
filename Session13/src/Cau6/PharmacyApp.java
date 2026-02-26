package Cau6;

import java.util.*;

public class PharmacyApp {
    private static List<Medicine> cart = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n||====================MENU====================||");
            System.out.println("||        1. Thêm thuốc vào đơn               ||");
            System.out.println("||        2. Điều chỉnh số lượng              ||");
            System.out.println("||        3. Xóa thuốc                        ||");
            System.out.println("||        4. In hóa đơn                       ||");
            System.out.println("||        5. Tìm thuốc giá rẻ                 ||");
            System.out.println("||        6. Thoát                            ||");
            System.out.println("||============================================||");
            System.out.print("Chọn lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addMedicine();
                case 2 -> adjustQuantity();
                case 3 -> removeMedicine();
                case 4 -> printInvoice();
                case 5 -> findCheapMedicine();
                case 6 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private static void addMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        for (Medicine m : cart) {
            if (m.getDrugId().equals(id)) {
                System.out.print("Thuốc đã tồn tại. Nhập số lượng thêm: ");
                int extra = Integer.parseInt(sc.nextLine());
                m.setQuantity(m.getQuantity() + extra);
                System.out.println("Đã cộng dồn số lượng!");
                return;
            }
        }

        System.out.print("Nhập tên thuốc: ");
        String name = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());

        cart.add(new Medicine(id, name, price, qty));
        System.out.println("Thêm thuốc thành công !");
    }

    private static void adjustQuantity() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();
        for (int i = 0; i < cart.size(); i++) {
            Medicine m = cart.get(i);
            if (m.getDrugId().equals(id)) {
                System.out.print("Nhập số lượng mới: ");
                int newQty = Integer.parseInt(sc.nextLine());
                if (newQty <= 0) {
                    cart.remove(i);
                    System.out.println("Đã xóa thuốc khỏi đơn do số lượng = 0.");
                } else {
                    m.setQuantity(newQty);
                    System.out.println("Cập nhật thuốc thành công !");
                }
                return;
            }
        }
        System.out.println("Thuốc không tồn tại trong đơn. Vui lòng nhập lại.");
    }

    private static void removeMedicine() {
        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = sc.nextLine();
        boolean removed = cart.removeIf(m -> m.getDrugId().equals(id));
        if (removed) System.out.println("Đã xóa thuốc thành công.");
        else System.out.println("Id thuốc không tồn tại !");
    }

    private static void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống!");
            return;
        }
        System.out.printf("%-10s %-20s %-12s %-10s\n", "Mã Thuốc", "Tên Thuốc", "Đơn Giá", "Số Lượng");
        double total = 0;
        for (Medicine m : cart) {
            System.out.printf("%-10s %-20s %-12.2f %-10d\n",
                    m.getDrugId(), m.getDrugName(), m.getUnitPrice(), m.getQuantity());
            total += m.getTotalPrice();
        }
        System.out.printf("Tổng tiền: %.2f VNĐ\n", total);

        cart.clear();
        System.out.println("Đơn đã được lưu và dọn dẹp cho bệnh nhân tiếp theo.");
    }

    private static void findCheapMedicine() {
        System.out.println("Các thuốc có giá dưới 50.000 VNĐ:");
        boolean found = false;
        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.printf("- %s (%s): %.2f\n", m.getDrugName(), m.getDrugId(), m.getUnitPrice());
                found = true;
            }
        }
        if (!found) System.out.println("Không có thuốc nào giá dưới 50.000 VNĐ.");
    }
}
