import java.util.Scanner;

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bookId;
        while (true) {
            System.out.print("Nhập Mã sách (LIB-xxxx-S): ");
            bookId = sc.nextLine();
            if (bookId.matches("LIB-\\d{4}-S")) break;
            System.out.println("Định dạng sai! Vui lòng nhập lại");
        }

        String isbn;
        while (true) {
            System.out.print("Nhập mã ISBN-10 (10 chữ số): ");
            isbn = sc.nextLine();
            if (isbn.matches("\\d{10}")) break;
            System.out.println("ISBN phải đúng 10 chữ số!");
        }

        int year;
        while (true) {
            System.out.print("Nhập năm xuất bản: ");
            String inputYear = sc.nextLine();
            if (inputYear.matches("\\d{4}")) {
                year = Integer.parseInt(inputYear);
                if (year <= 2026) break;
            }
            System.out.println("Năm không hợp lệ (Phải <= 2026)!");
        }

        System.out.print("Nhập tên sách thô: ");
        String rawTitle = sc.nextLine();
        String temp = rawTitle.trim().toLowerCase();
        String[] words = temp.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String formatted = word.substring(0, 1).toUpperCase() + word.substring(1);
                result.append(formatted).append(" ");
            }
        }
        String cleanTitle = result.toString().trim();

        System.out.print("Nhập tên tác giả thô: ");
        String rawAuthor = sc.nextLine();

        String authorLower = rawAuthor.trim().toLowerCase();
        String[] words1 = authorLower.split("\\s+");
        StringBuilder authorBuilder = new StringBuilder();

        for (String w : words1) {
            if (!w.isEmpty()) {
                String formattedWord = Character.toUpperCase(w.charAt(0)) + w.substring(1);
                authorBuilder.append(formattedWord).append(" ");
            }
        }
        String cleanAuthor = authorBuilder.toString().trim();

        StringBuilder citationBuilder = new StringBuilder();
        citationBuilder.append("[").append(bookId).append("] - ")
                .append(cleanTitle).append(" - ")
                .append(cleanAuthor).append(" (")
                .append(year).append(")");

        System.out.println("\n===== KẾT QUẢ BIÊN MỤC =====");
        System.out.println("Mã sách chuẩn: " + bookId);
        System.out.println("ISBN-10: " + isbn);
        System.out.println("Tên sách: " + cleanTitle);
        System.out.println("Tác giả: " + cleanAuthor);
        System.out.println("Năm XB: " + year);
        System.out.println("Trích dẫn: " + citationBuilder.toString());
        System.out.println("============================");
    }
}