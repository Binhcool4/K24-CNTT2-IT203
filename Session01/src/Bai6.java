import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ tự của sách trong hệ thống: ");
        int stt = sc.nextInt();

        int shelf = (stt - 1) / 25 + 1;

        int position = (stt - 1) % 25 + 1;

        String zone = (shelf <= 10) ? "Khu Cận (Gần cửa)" : "Khu Viễn (Xa cửa)";

        System.out.println("\n--- THÔNG TIN ĐỊNH VỊ ---");
        System.out.println("Sách số: " + stt);
        System.out.println("Địa chỉ: Kệ " + shelf + " - Vị trí " + position);
        System.out.println("Phân khu: " + zone);
    }
}