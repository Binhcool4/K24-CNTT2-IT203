public class Bai1 {
    public static void main(String[] args) {
        Student sv1 = new Student("SV001", "Nguyễn Văn A", 2003, 8.2);
        Student sv2 = new Student("SV002", "Trần Thị B", 2004, 7.6);

        sv1.hienThiThongTin();
        sv2.hienThiThongTin();
    }
}
class Student {
    private String maSV;
    private String hoTen;
    private int namSinh;
    private double diemTB;

    public Student(String maSV, String hoTen, int namSinh, double diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diemTB = diemTB;
    }

    public void hienThiThongTin() {
        System.out.println("Mã SV: " + maSV);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("Điểm trung bình: " + diemTB);
        System.out.println("----------------------");
    }
}