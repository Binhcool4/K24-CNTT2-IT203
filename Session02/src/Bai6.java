import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int openDays = 0;

        for (int i = 2; i <= 8; i++) {
            String dayName = (i == 8) ? "Chủ Nhật" : "Thứ " + i;
            System.out.print("Nhập số lượt mượn " + dayName + ": ");
            int count = sc.nextInt();

            if (count == 0) {
                continue;
            }

            openDays++;
            sum += count;

            if (count > max) {
                max = count;
            }

            if (count < min) {
                min = count;
            }
        }

        double average = (double) sum / openDays;

        System.out.println("\n--- KẾT QUẢ THỐNG KÊ ---");
        System.out.println("Lượt mượn cao nhất: " + max);
        System.out.println("Lượt mượn thấp nhất: " + min);
        System.out.printf("Trung bình lượt mượn: %.2f lượt/ngày\n", average);
    }
}
