package Cau5;

import java.util.Comparator;
import java.util.TreeSet;

public class Cau5 {
    public static void main(String[] args) {
        Comparator<Patient> priorityComparator = (p1, p2) -> {
            if (p1.severity != p2.severity) {
                return p1.severity - p2.severity;
            }
            int timeCompare = p1.arrivalTime.compareTo(p2.arrivalTime);

            if (timeCompare != 0) {
                return timeCompare;
            }

            return p1.name.compareTo(p2.name);
        };

        TreeSet<Patient> emergencyQueue = new TreeSet<>(priorityComparator);

        emergencyQueue.add(new Patient("A", 3, "8:00"));
        emergencyQueue.add(new Patient("B", 1, "8:15"));
        emergencyQueue.add(new Patient("C", 1, "8:05"));

        System.out.println("THỨ TỰ XỬ LÝ CẤP CỨU:");
        for (Patient p : emergencyQueue) {
            System.out.println(p);
        }
    }
}
