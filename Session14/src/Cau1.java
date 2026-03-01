import java.util.*;

public class Cau1 {
    public static void main(String[] args) {
        List<String> inputNames = List.of(
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        );

        // Sử dụng LinkedHashSet để lọc trùng và GIỮ THỨ TỰ
        Set<String> patientSet = new LinkedHashSet<>(inputNames);

        System.out.println("Danh sách gọi khám theo thứ tự:");
        int stt = 1;
        for (String name : patientSet) {
            System.out.println(stt + ". " + name);
            stt++;
        }
    }
}