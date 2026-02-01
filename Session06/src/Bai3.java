public class Bai3 {
    public static void main(String[] args) {
        Product p = new Product("SP01", "Chuột không dây", 250000);
        System.out.println("Thông tin ban đầu:");
        p.hienThiThongTin();
        System.out.println("Thử set giá = -100:");
        p.setGiaBan(-100);
        System.out.println("Thông tin sau khi set giá không hợp lệ:");
        p.hienThiThongTin();
    }
}
class Product {
    private String maSP;
    private String tenSP;
    private double giaBan;

    public Product(String maSP, String tenSP, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        setGiaBan(giaBan);
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        if (giaBan > 0) {
            this.giaBan = giaBan;
        } else {
            System.out.println("Giá bán không hợp lệ! Giá phải > 0");
        }
    }

    public void hienThiThongTin() {
        System.out.println("Mã SP: " + maSP);
        System.out.println("Tên SP: " + tenSP);
        System.out.println("Giá bán: " + giaBan);
        System.out.println("----------------------");
    }
}