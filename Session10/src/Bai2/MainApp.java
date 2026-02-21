package Bai2;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("===== QUẢN LÝ BÃI XE =====");

        // Khởi tạo các đối tượng thông qua kiểu dữ liệu trừu tượng Vehicle
        Vehicle myCar = new Car("Toyota");
        Vehicle myBike = new Bicycle("Thống Nhất");

        // Gọi phương thức
        myCar.displayBrand();
        myCar.move();

        myBike.displayBrand();
        myBike.move();

        System.out.println("==========================");
    }
}
