package BTTH;

public class EmergencyPatient extends Patient {
    private int priorityLevel; // 1: Cao nhất

    public EmergencyPatient(String id, String fullName, int age, String medicalCondition, int priorityLevel) {
        super(id, fullName, age, medicalCondition);
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() { return priorityLevel; }

    @Override
    public void showInfo() {
        System.out.printf("| %-5s | %-20s | %-5d | %-20s | Ưu tiên: %d |\n", id, fullName, age, "CẤP CỨU", priorityLevel);
    }
}
