package Bai5;


public class OfficeStaff extends Employee {

    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // Lương văn phòng = Lương cơ bản
    }
}
