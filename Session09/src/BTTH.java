class Employee {
    protected String name;
    protected double baseSalary;
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    double getSalary() {
        return baseSalary;
    }
    double getSalary(int bonus) {
        return baseSalary + bonus;
    }
}
class Manager extends Employee {
    private double allowance;

    public Manager(String name, double baseSalary, double allowance) {
        super(name, baseSalary);
        this.allowance = allowance;
    }

    @Override
    double getSalary() {
        return super.getSalary() + allowance;
    }
}
class Developer extends Employee {
    private int overtimeHours;
    private double overtimeRate;

    public Developer(String name, double baseSalary, int overtimeHours, double overtimeRate) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    @Override
    double getSalary() {
        return baseSalary + overtimeHours * overtimeRate;
    }

}
public class BTTH {
    public static void main(String[] args) {
        Employee e1 = new Manager("Huy", 10_000_000, 3_000_000);
        Employee e2 = new Developer("Nam", 8_000_000, 20, 200_000);
        System.out.println("Luong Manager: " + e1.getSalary());
        System.out.println("Luong Developer: " + e2.getSalary());
        System.out.println("Luong co thuong (Employee): " + e1.getSalary(1_000_000));
    }
}