import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        String bookID, bookName;
        int publishYear;
        double price;
        boolean isAvailable;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        bookID = scanner.nextLine();
        System.out.print("Nhập tên sách: ");
        bookName = scanner.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        publishYear = scanner.nextInt();
        System.out.print("Nhập giá sách: ");
        price = scanner.nextDouble();
        System.out.print("Sách có sẵn không (true/false): ");
        isAvailable = scanner.nextBoolean();

        System.out.println("--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.printf("Tên sách: %s%n", bookName);
        System.out.printf("Mã số: %s | Tuổi thọ: %d năm%n", bookID, 2026 - publishYear);
        System.out.printf("Giá bán: %.2f%n", price);
        System.out.printf("Tình trạng: %s%n", isAvailable ? "Còn sách" : "Hết sách");
    }
}