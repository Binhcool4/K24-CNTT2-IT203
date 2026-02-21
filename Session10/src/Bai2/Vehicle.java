package Bai2;

public abstract class Vehicle {
    protected String brand;

    // Constructor của lớp trừu tượng dùng để khởi tạo thuộc tính chung
    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Phương thức trừu tượng: Chỉ định nghĩa "cái gì", không định nghĩa "như thế nào"
    public abstract void move();

    // Phương thức thông thường: Dùng chung cho mọi lớp con
    public void displayBrand() {
        System.out.print(brand + " - Cách di chuyển: ");
    }
}
