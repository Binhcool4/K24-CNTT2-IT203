import java.util.*;

public class Cau3 {
    public static void main(String[] args) {
        Set<String> thanhPhanThuoc = new HashSet<>(Arrays.asList("Aspirin", "Caffeine", "Paracetamol"));
        Set<String> chatDiUng = new HashSet<>(Arrays.asList("Penicillin", "Aspirin"));

        Set<String> canhBao = new HashSet<>(thanhPhanThuoc);
        canhBao.retainAll(chatDiUng); // Giữ lại những chất có mặt trong cả 2 tập hợp

        Set<String> thanhPhanAnToan = new HashSet<>(thanhPhanThuoc);
        thanhPhanAnToan.removeAll(chatDiUng); // Xóa bỏ những chất mà bệnh nhân bị dị ứng

        System.out.println("Thuốc: " + thanhPhanThuoc);
        System.out.println("Dị ứng: " + chatDiUng);
        System.out.println("------------------------------");
        System.out.println("Cảnh báo dị ứng: " + canhBao);
        System.out.println("Thành phần an toàn: " + thanhPhanAnToan);
    }
}