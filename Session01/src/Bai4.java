import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá sách (USD - kiểu double): ");
        double priceUSD = scanner.nextDouble();

        float rate = 25450.0f;

        double priceVND = priceUSD * rate;

        long roundedPrice = (long) priceVND;

        System.out.println("Giá chính xác (số thực): " + priceVND);
        System.out.println("Giá làm tròn để thanh toán (long): " + roundedPrice);
        System.out.println("Giá làm tròn để thanh toán (long): " + roundedPrice);
    }
}