package BTTH;

public class Student {
    private String id;
    private String name;
    static int studentCount = 0;
    static final String SCHOOL_NAME = "BDC University";
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        studentCount++;
    }
    public void displayInfo() {
        System.out.println("Mã SV: " + id);
        System.out.println("Tên SV: " + name);
        System.out.println("Trường: " + SCHOOL_NAME);
        System.out.println("-------------------");
    }
    public static void showTotalStudent() {
        System.out.println("Tổng số sinh viên: " + studentCount);
    }
}