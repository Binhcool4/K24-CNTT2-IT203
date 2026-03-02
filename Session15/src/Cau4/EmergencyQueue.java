package Cau4;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class EmergencyQueue {
    private PriorityQueue<EmergencyPatient> pQueue = new PriorityQueue<>(
            Comparator.comparingInt(EmergencyPatient::getPriority)
    );

    public void addPatient(EmergencyPatient p) {
        pQueue.add(p);
        System.out.println("Đã tiếp nhận: " + p.getName() + " (Mức: " + p.getPriority() + ")");
    }

    public EmergencyPatient callNextPatient() {
        return pQueue.poll();
    }

    public void displayQueue() {
        if (pQueue.isEmpty()) {
            System.out.println("Hàng đợi trống.");
            return;
        }
        List<EmergencyPatient> sortedList = new ArrayList<>(pQueue);
        sortedList.sort(Comparator.comparingInt(EmergencyPatient::getPriority));
        sortedList.forEach(System.out::println);
    }
}

