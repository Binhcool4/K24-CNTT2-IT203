public class Bai2 {
    public static void main(String[] args) {
        String description = "Sách giáo khoa Toán lớp 12, Kệ: A1-102, tình trạng mới";

        if (description.contains("Kệ:")) {
            int start = description.indexOf("Kệ:") + 4;

            int end = description.indexOf(",", start);
            if (end == -1) {
                end = description.length();
            }

            String position = description.substring(start, end).trim();

            String newDesc = description.replace("Kệ:", "Vị trí lưu trữ:");

            System.out.printf("Vị trí tìm thấy: %s\n", position);
            System.out.printf("Mô tả mới: %s\n", newDesc);
        } else {
            System.out.println("Không tìm thấy thông tin vị trí.");
        }
    }
}
