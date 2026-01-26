import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách trả:");
        int m = Integer.parseInt(sc.nextLine());
        long totalFine = 0;

        for(int i = 1; i <= m; i++) {
            System.out.print("Nhập số ngày quá hạn cuôn sách " + i + ": ");
            int n = Integer.parseInt(sc.nextLine());

            totalFine += n * 5000;
        }

        System.out.println("Tổng tiền phạt là " + totalFine);
    }
}
