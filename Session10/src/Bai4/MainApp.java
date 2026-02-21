package Bai4;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("===== HỆ THỐNG ĐIỀU KHIỂN THÔNG MINH =====");

        // Sử dụng Anonymous Class để tạo nhanh đối tượng smartLight
        // Chúng ta "new" ngay cái Interface và định nghĩa thân hàm tại chỗ
        RemoteControl smartLight = new RemoteControl() {
            @Override
            public void powerOn() {
                System.out.println("Hành động: Đèn cảm ứng đã bật sáng!");
            }

            // Ở đây em có thể Override cả checkBattery() nếu muốn,
            // nhưng vì nó là default nên không bắt buộc.
        };

        // 3. Thực thi các phương thức
        smartLight.powerOn();      // Gọi phương thức nặc danh vừa định nghĩa
        smartLight.checkBattery(); // Gọi phương thức mặc định từ Interface

        System.out.println("===========================================");
    }
}
