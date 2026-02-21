package Bai3;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("===== MÔ PHỎNG SINH VẬT =====");

        Duck donald = new Duck("Vịt Donald");
        Fish nemo = new Fish("Cá Nemo");

        // Kiểm tra Vịt
        System.out.println("--- Khả năng của Vịt ---");
        donald.swim();
        donald.fly();

        // Kiểm tra Cá
        System.out.println("\n--- Khả năng của Cá ---");
        nemo.swim();
        // nemo.fly(); // Dòng này sẽ báo lỗi biên dịch vì Cá không có kỹ năng Flyable

        System.out.println("==============================");
    }
}
