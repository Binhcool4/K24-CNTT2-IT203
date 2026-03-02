package Cau2;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {
    Queue<Patient> queue = new LinkedList<>();

    public void addPatient(Patient p) {
        queue.add(p);
    }

    public Patient callNextPatient() {
        if(isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public Patient peekNextPatient() {
        if(isEmpty()) {
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if(queue.isEmpty()) {
            System.out.println("Hàng đợi trống");
        } else {
            for(Patient p : queue) {
                System.out.println(p);
            }
        }
    }
}
