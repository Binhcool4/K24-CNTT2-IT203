package Bai1;

public class MainApp {
    public static void main(String[] args) {
        Shape hinhTron = new Circle(5.0);
        Shape hinhChuNhat = new Rectangle(4.0, 6.0);

        System.out.println("[Hình Tròn]");
        System.out.printf("- Diện tích: %.2f\n", hinhTron.getArea());
        System.out.printf("- Chu vi: %.2f\n", hinhTron.getPerimeter());

        System.out.println("\n[Hình Chữ Nhật]");
        System.out.printf("- Diện tích: %.2f\n", hinhChuNhat.getArea());
        System.out.printf("- Chu vi: %.2f\n", hinhChuNhat.getPerimeter());
        System.out.println("======================================");
    }
}
