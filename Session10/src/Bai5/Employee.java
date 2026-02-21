package Bai5;


public abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Phương thức trừu tượng: Mỗi loại nhân viên sẽ có cách tính tổng lương khác nhau
    public abstract double calculateSalary();

    public String getName() {
        return name;
    }
}
