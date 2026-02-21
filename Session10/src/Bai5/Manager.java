package Bai5;


public class Manager extends Employee implements BonusCalculator {
    private double kpiPerformance; // Hệ số hoàn thành công việc (0.0 - 1.0)

    public Manager(String name, double baseSalary, double kpiPerformance) {
        super(name, baseSalary);
        this.kpiPerformance = kpiPerformance;
    }

    @Override
    public double getBonus() {
        // Thưởng = 20% lương cơ bản * hệ số KPI
        return baseSalary * 0.2 * kpiPerformance;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + getBonus();
    }
}