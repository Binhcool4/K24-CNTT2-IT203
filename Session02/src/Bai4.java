import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("Nhập mã ID sách mới (phải > 0): ");
            int id = sc.nextInt();

            if(id > 0) {
                System.out.printf("Xác nhận: Mã sách %d đã được ghi nhận", id);
                break;
            } else {
                System.out.println("Lỗi: ID phải là số dương");
            }
        } while(true);
    }
}
