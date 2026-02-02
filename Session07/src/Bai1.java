public class Bai1 {
    public static void main(String[] args) {
        Student student1 = new Student("S001", "Alice");
        Student student2 = new Student("S002", "Bob");
        Student student3 = new Student("S003", "Charlie");

        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        Student.showTotalStudents();
    }
}
class Student {
    private String id;
    private String name;

    static int totalStudents = 0;

    public Student (String id, String name) {
        this.id = id;
        this.name = name;
        totalStudents++;
    }
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("-------------------");
    }
    public static void showTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}