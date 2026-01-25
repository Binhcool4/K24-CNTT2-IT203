import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bookID ;
        String title;
        float price;
        int quantity;
        boolean isAvailable;

        System.out.println("Nhập mã sách : ");
        bookID = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên sách : ");
        title = sc.nextLine();

        System.out.println("Nhập giá sách : ");
        price = sc.nextFloat();

        System.out.println("Nhập số lượng : ");
        quantity = sc.nextInt();

        System.out.println("Nhập trạng thái : ");
        isAvailable = sc.nextBoolean();

        float totalValue = quantity * price;
        boolean isLargeStock = quantity > 100;
        boolean canBorrow = isAvailable && quantity > 0;

        System.out.println("\n===== BÁO CÁO TÌNH TRẠNG SÁCH =====");
        System.out.printf("Mã sách: %d\n", bookID);
        System.out.printf("Tên sách: %s\n", title);
        System.out.printf("Giá nhập: %.2f\n", price);
        System.out.printf("Số lượng: %d\n", quantity);
        System.out.printf("Tổng giá trị kho: %.2f\n", totalValue);

        System.out.printf("Kho lớn (>100 sách): %b\n", isLargeStock);
        System.out.printf("Trạng thái: %s\n", isAvailable ? "Còn hàng" : "Hết hàng");
        System.out.printf("Có thể mượn: %b\n", canBorrow);
    }
}