package project.mini;

public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private double math;
    private double physics;
    private double chemistry;
    private double avg;
    private String rank;

    public Student(String id, String name, int age, String gender,
                   double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calculateAvgAndRank();
    }

    /* ================= BUSINESS ================= */
    public void calculateAvgAndRank() {
        avg = (math + physics + chemistry) / 3;

        if (avg >= 8.0 && math >= 6.5 && physics >= 6.5 && chemistry >= 6.5) {
            rank = "Giỏi";
        } else if (avg >= 6.5 && math >= 5 && physics >= 5 && chemistry >= 5) {
            rank = "Khá";
        } else if (avg >= 5.0 && math >= 3.5 && physics >= 3.5 && chemistry >= 3.5) {
            rank = "Trung bình";
        } else {
            rank = "Yếu";
        }
    }

    /* ================= GETTER ================= */
    public String getId() { return id; }
    public String getName() { return name; }
    public double getAvg() { return avg; }
    public String getRank() { return rank; }

    /* ================= SETTER ================= */
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }

    public void setScores(double math, double physics, double chemistry) {
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calculateAvgAndRank();
    }

    /* ================= DISPLAY ================= */
    public void display() {
        System.out.printf("%-8s %-20s %-5d %-8s %-6.2f %-10s\n",
                id, name, age, gender, avg, rank);
    }
}
