import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai5 {
    public static void main(String[] args) {
        String logData = "2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345\n" +
                "2024-05-21 | User: TranVanB | Action: RETURN | BookID: BK67890\n" +
                "2024-05-22 | User: LeThiC | Action: BORROW | BookID: BK11223";


        String logPattern = "(\\d{4}-\\d{2}-\\d{2}) \\| User: (.*?) \\| Action: (BORROW|RETURN) \\| BookID: (\\w+)";

        Pattern pattern = Pattern.compile(logPattern);
        Matcher matcher = pattern.matcher(logData);

        int borrowCount = 0;
        int returnCount = 0;

        System.out.println("--- CHI TIẾT LOG ĐÃ TÁCH ---");
        while (matcher.find()) {
            String date = matcher.group(1);
            String user = matcher.group(2);
            String action = matcher.group(3);
            String bookID = matcher.group(4);

            System.out.println("Ngày: " + date);
            System.out.println("Người dùng: " + user);
            System.out.println("Hành động: " + action);
            System.out.println("Mã sách: " + bookID);
            System.out.println("-------------------------");

            if (action.equals("BORROW")) {
                borrowCount++;
            } else if (action.equals("RETURN")) {
                returnCount++;
            }
        }

        System.out.println("\n--- BÁO CÁO THỐNG KÊ ---");
        System.out.println("Tổng số lượt MƯỢN (BORROW): " + borrowCount);
        System.out.println("Tổng số lượt TRẢ (RETURN): " + returnCount);
    }
}
