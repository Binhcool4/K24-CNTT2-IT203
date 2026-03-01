package Cau6;
import java.util.*;

public class Cau6 {
    public static void main(String[] args) {
        List<Patient> listInput = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 45, "Nội tiết"),
                new Patient("Mai", 25, "Tim mạch"),
                new Patient("Bình", 50, "Nội tiết"),
                new Patient("An", 20, "Nội tiết")
        );

        Map<String, List<Patient>> mapKhoa = new HashMap<>();

        for (Patient p : listInput) {
            String tenKhoa = p.department;

            // Nếu khoa này chưa có trong Map, tạo một List mới rỗng
            if (!mapKhoa.containsKey(tenKhoa)) {
                mapKhoa.put(tenKhoa, new ArrayList<>());
            }

            // Lấy List của khoa đó ra và thêm bệnh nhân vào
            mapKhoa.get(tenKhoa).add(p);
        }

        System.out.println("Cấu trúc dữ liệu Map:");
        for (var entry : mapKhoa.entrySet()) {
            System.out.println("Khoa " + entry.getKey() + ": " + entry.getValue());
        }

        // Tìm khoa đông bệnh nhân nhất
        String khoaDongNhat = "";
        int maxBenhNhan = -1;

        for (var entry : mapKhoa.entrySet()) {
            int soLuong = entry.getValue().size();
            if (soLuong > maxBenhNhan) {
                maxBenhNhan = soLuong;
                khoaDongNhat = entry.getKey();
            }
        }

        System.out.println("Khoa " + khoaDongNhat + " đang đông nhất (" + maxBenhNhan + " bệnh nhân).");
    }
}
