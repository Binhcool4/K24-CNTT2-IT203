package Bai4;


public interface RemoteControl {
    // Phương thức trừu tượng (bắt buộc triển khai)
    void powerOn();

    // Default Method: Phương thức có sẵn logic, lớp con không bắt buộc phải viết lại
    default void checkBattery() {
        System.out.println("Kiểm tra thiết bị: Pin ổn định.");
    }
}
