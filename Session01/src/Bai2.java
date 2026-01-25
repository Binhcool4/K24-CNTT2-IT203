import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        int n,m, total;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số ngày chậm trễ: ");
        n = scanner.nextInt();
        System.out.print("Nhập số lượng sách mượn: ");
        m = scanner.nextInt();
        total = n * m * 5000;
        System.out.printf("Tiền phạt gốc: %d VND%n", total);

        if (n>7 && m >=3) {
            total += total * 20 / 100;
        }

        System.out.printf("Tiền phạt sau điều chỉnh: %d VND%n", total);
        System.out.printf("Yêu cầu khoá thẻ: %s%n", (total>50000) ? "True" : "False");
    }
}