import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String Title = "   lập  TRÌNH java   Cơ bản ";
        String Author = "nguyễn văn a";

        String cleanTitle = Title.trim().replaceAll("\\s+", " ").toUpperCase();

        String authorTrimmed = Author.trim().toLowerCase();
        String[] words = authorTrimmed.split("\\s+");
        String cleanAuthor = "";

        for (String word : words) {
            if (!word.isEmpty()) {
                // Lấy chữ cái đầu viết hoa + phần còn lại của từ
                String firstChar = word.substring(0, 1).toUpperCase();
                String remainingChars = word.substring(1);
                cleanAuthor += firstChar + remainingChars + " ";
            }
        }
        cleanAuthor = cleanAuthor.trim();

        String result = "[" + cleanTitle + "] - Tác giả: " + cleanAuthor;
        System.out.println(result);
    }
}