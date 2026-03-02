package BTTH;
import java.util.PriorityQueue;
import java.util.Stack;

public class HospitalService implements IManagement<Patient> {
    // Sử dụng PriorityQueue để tự động sắp xếp theo mức độ ưu tiên và tuổi
    private PriorityQueue<Patient> waitingQueue = new PriorityQueue<>((p1, p2) -> {
        int priority1 = (p1 instanceof EmergencyPatient) ? ((EmergencyPatient) p1).getPriorityLevel() : 10;
        int priority2 = (p2 instanceof EmergencyPatient) ? ((EmergencyPatient) p2).getPriorityLevel() : 10;
        if (priority1 != priority2) return Integer.compare(priority1, priority2);
        return Integer.compare(p2.getAge(), p1.getAge()); // Ưu tiên người già hơn nếu cùng mức độ
    });

    @Override
    public void add(Patient p) {
        waitingQueue.add(p);
        System.out.println("Đăng ký thành công cho: " + p.getFullName());
    }

    // Gọi khám (Dequeue)
    public void callNextPatient(String diagnosis) {
        if (waitingQueue.isEmpty()) {
            System.out.println("Lỗi: Hàng đợi rỗng!");
            return;
        }
        Patient p = waitingQueue.poll(); // Lấy bệnh nhân đầu hàng
        p.addHistory("Khám ngày " + new java.util.Date() + ": " + diagnosis);
        System.out.println("Đã khám xong cho BN: " + p.getFullName() + ". Hồ sơ đã cập nhật vào Stack.");
    }

    @Override
    public void display() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Không có bệnh nhân chờ.");
            return;
        }
        System.out.println("--- DANH SÁCH HÀNG ĐỢI ---");
        waitingQueue.forEach(Patient::showInfo);
    }

    @Override
    public Patient search(String id) {
        return waitingQueue.stream().filter(p -> p.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    @Override
    public void sort() {
        System.out.println("Hàng đợi đã được tự động sắp xếp theo mức ưu tiên.");
    }

    public void showPatientHistory(Patient p) {
        if (p == null || p.getHistory().isEmpty()) {
            System.out.println("Lịch sử trống!");
            return;
        }
        System.out.println("Lịch sử (Gần nhất trước):");
        Stack<String> temp = (Stack<String>) p.getHistory().clone();
        while (!temp.isEmpty()) {
            System.out.println("- " + temp.pop()); // Nguyên lý LIFO
        }
    }
}
