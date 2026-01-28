import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

public class Bai3 {
    public static void main(String[] args) {
        String[] transactions = {"BK001-20/01", "BK005-21/01", "BK099-22/01", "BK123-23/01", "BK150-24/01",};
        String date = LocalDate.now().toString();
        Instant startSB = Instant.now();

        StringBuilder sb = new StringBuilder();
        sb.append("--- BÁO CÁO MƯỢN SÁCH ---\n");
        sb.append("Ngày tạo: ").append(date).append("\n");

        for (int i = 0; i < transactions.length; i++) {
            sb.append("Giao dịch: ").append(transactions[i]).append("\n");
        }
        Instant endSB = Instant.now();
        Instant startStr = Instant.now();

        String report = "--- BÁO CÁO MƯỢN SÁCH ---\n";
        report += "Ngày tạo: " + date + "\n";

        for (int i = 0; i < transactions.length; i++) {
            report += "Giao dịch: " + transactions[i] + "\n";
        }
        Instant endStr = Instant.now();
        System.out.println(sb);
        long timeSB = Duration.between(startSB, endSB).toMillis();
        long timeStr = Duration.between(startStr, endStr).toMillis();

        System.out.printf("Số thời gian thực thi đối với StringBuilder: %d\n", timeSB);
        System.out.printf("Số thời gian thực thi đối với String: %d\n", timeStr);
    }
}
