package Cau3;

public class App {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();

        String[] process1 = {"PUSH", "PUSH", "POP", "POP"};
        if (checker.checkProcess(process1)) {
            System.out.println("Quy trình HỢP LỆ.");
        } else {
            System.out.println("Quy trình KHÔNG HỢP LỆ.");
        }

        String[] process2 = {"PUSH", "PUSH", "POP"};
        if (checker.checkProcess(process2)) {
            System.out.println("Quy trình HỢP LỆ.");
        } else {
            System.out.println("Quy trình KHÔNG HỢP LỆ.");
        }

        String[] process3 = {"PUSH", "POP", "POP"};
        if (checker.checkProcess(process3)) {
            System.out.println("Quy trình HỢP LỆ.");
        } else {
            System.out.println("Quy trình KHÔNG HỢP LỆ.");
        }
    }
}
