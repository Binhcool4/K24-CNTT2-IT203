package Bai5;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("================ BẢNG LƯƠNG NHÂN VIÊN ================");
        System.out.printf("%-15s | %-12s | %-12s | %-12s\n", "Tên", "Lương CB", "Tiền Thưởng", "Tổng Nhận");
        System.out.println("------------------------------------------------------");

        // Sử dụng Đa hình để quản lý danh sách nhân viên
        Employee[] list = new Employee[2];
        list[0] = new OfficeStaff("Nguyễn Văn An", 10000000);
        list[1] = new Manager("Bùi Đức Lợi", 20000000, 0.9); // KPI đạt 90%

        for (Employee e : list) {
            double bonus = 0;

            // Kiểm tra xem nhân viên này có năng lực tính thưởng (BonusCalculator) không?
            if (e instanceof BonusCalculator) {
                bonus = ((BonusCalculator) e).getBonus(); // Ép kiểu để lấy tiền thưởng
            }

            System.out.printf("%-15s | %,12.0f | %,12.0f | %,12.0f\n",
                    e.getName(), e.baseSalary, bonus, e.calculateSalary());
        }
        System.out.println("======================================================");
    }
}
