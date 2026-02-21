package Bai2;

public class Car extends Vehicle {

    public Car(String brand) {
        // Sử dụng super để gọi constructor của lớp cha Vehicle
        super(brand);
    }

    @Override
    public void move() {
        System.out.println("Di chuyển bằng động cơ");
    }
}