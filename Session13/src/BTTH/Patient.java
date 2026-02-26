package BTTH;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String diagnosis; // Bệnh lý

    public Patient(int id, String name, int age, String gender, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    @Override
    public String toString() {
        return String.format("| ID: %-4d | Tên: %-15s | Tuổi: %-3d | Giới tính: %-5s | Bệnh: %-15s |",
                id, name, age, gender, diagnosis);
    }
}
