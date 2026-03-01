import java.util.*;

public class Cau4 {
    public static void main(String[] args) {
        List<String> caBenh = Arrays.asList("Cúm A", "Sốt xuất huyết", "Cúm A", "Covid-19", "Cúm A", "Sốt xuất huyết");

        // Sử dụng TreeMap để vừa lưu trữ số lượng, vừa tự động sắp xếp theo Tên bệnh (Key)
        Map<String, Integer> baoCao = new TreeMap<>();

        for (String tenBenh : caBenh) {
            if (baoCao.containsKey(tenBenh)) {
                // Nếu bệnh đã có trong Map, lấy số cũ cộng thêm 1
                baoCao.put(tenBenh, baoCao.get(tenBenh) + 1);
            } else {
                // Nếu là bệnh mới xuất hiện lần đầu, đặt số lượng là 1
                baoCao.put(tenBenh, 1);
            }
        }

        System.out.println("BÁO CÁO TÌNH HÌNH DỊCH BỆNH:");
        for (Map.Entry<String, Integer> entry : baoCao.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}