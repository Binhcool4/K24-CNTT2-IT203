import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã thẻ thư viện: ");
        String maThe = sc.nextLine().trim();
        String thongBao = kiemTraMaThe(maThe);
        System.out.println(thongBao);
        sc.close();
    }

    public static String kiemTraMaThe(String maThe) {
        String regex = "^TV\\d{4}\\d{5}$";

        if (maThe == null || maThe.isEmpty()) {
            return "Lỗi: Mã thẻ không được để trống.";
        }
        if (!maThe.matches(regex)) {
            if (maThe.length() != 11) {
                return "Lỗi: Độ dài mã thẻ phải là 11 ký tự.";
            }

            if (!maThe.startsWith("TV")) {
                return "Lỗi: Mã thẻ phải bắt đầu bằng 'TV'.";
            }

            String nam = maThe.substring(2, 6);
            if (!nam.matches("\\d{4}")) {
                return "Lỗi: năm vào học phải là 4 chữ số.";
            }

            String soCuoi = maThe.substring(6);
            if (!soCuoi.matches("\\d{5}")) {
                return "Lỗi : Phần cuối của mã thẻ phải là 5 chữ số.";
            }
            return "Mã thẻ không hợp lệ.";
        }
        return "Mã thẻ hợp lệ: ";
    }
}
