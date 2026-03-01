import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cau2 {
    public static void main(String[] args) {
        // HashMap: Key là Mã thuốc, Value là Tên thuốc
        Map<String, String> danhMucThuoc = new HashMap<>();

        danhMucThuoc.put("T01", "Paracetamol");
        danhMucThuoc.put("T02", "Ibuprofen");
        danhMucThuoc.put("T03", "Berberin");
        danhMucThuoc.put("T04", "Amoxicillin");
        danhMucThuoc.put("T05", "Decolgen");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã thuốc cần tra cứu: ");
        String maNhap = scanner.nextLine().toUpperCase();

        if (danhMucThuoc.containsKey(maNhap)) {
            String tenThuoc = danhMucThuoc.get(maNhap);
            System.out.println("Tên thuốc: " + tenThuoc);
        } else {
            System.out.println("Thuốc không có trong danh mục BHYT.");
        }

        scanner.close();
    }
}