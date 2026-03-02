package BTTH;
import java.util.Stack;

public class Patient extends Person {
    protected String medicalCondition;
    protected Stack<String> history = new Stack<>(); // Stack lưu lịch sử

    public Patient(String id, String fullName, int age, String medicalCondition) {
        super(id, fullName, age);
        this.medicalCondition = medicalCondition;
    }

    public void addHistory(String record) { history.push(record); }
    public Stack<String> getHistory() { return history; }

    @Override
    public void showInfo() {
        System.out.printf("| %-5s | %-20s | %-5d | %-20s |\n", id, fullName, age, medicalCondition);
    }
}

