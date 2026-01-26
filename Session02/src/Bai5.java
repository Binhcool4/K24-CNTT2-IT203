import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 100;
        int ngayTre = 0;

        System.out.println("--- HỆ THỐNG ĐÁNH GIÁ ĐỘC GIẢ ---");
        System.out.println("(Nhập số ngày trễ. Nhập 999 để kết thúc)");
        while (true) {
            System.out.print("Số ngày trễ của lần này: ");
            ngayTre = sc.nextInt();

            if(ngayTre == 999) break;

            if(ngayTre <= 0) {
                score += 5;
                System.out.println("Trả đúng hạn: +5 điểm");
            } else {
                int diemPhat = ngayTre * 2;
                score -= diemPhat;
                System.out.printf("Trả trễ %d ngày: %d điểm\n", ngayTre, diemPhat);
            }
        }

        System.out.printf("Tổng điểm uy tín: %d\n", score);
        if(score > 120) {
            System.out.println("Xếp loại: Độc giả Thân thiết");
        } else if(score > 80) {
            System.out.println("Xếp loại: Độc giả Tiêu chuẩn");
        } else {
            System.out.println("Xếp loại: Độc giả cần lưu ý");
        }
    }
}
