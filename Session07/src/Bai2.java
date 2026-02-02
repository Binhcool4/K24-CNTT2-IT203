public class Bai2 {
    static class Student{
        String name;
        public Student(String name){ this.name = name;}
    }

    public static void main(String[] args) {
        System.out.println("Kiểu nguyên thủy (int)");
        int a = 10;
        int b = a;
        b = 20;

        System.out.println("Giá trị a: " + a);
        System.out.println("Giá trị b: " + b);
        // Biến nguyên thủy sao chép giá trị độc lập

        System.out.println("Kiểu tham chiếu(object)");
        Student sv1 = new Student("Lợi");
        Student sv2 = sv1;

        sv2.name = "Hưng";

        System.out.println("Tên của sv1: " + sv1.name);
        System.out.println("Tên của sv2: " + sv2.name);
        // Biến tham chiếu trỏ chung vào một đối tượng
    }
}