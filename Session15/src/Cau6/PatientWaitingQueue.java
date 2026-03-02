package Cau6;
import java.util.*;

public class PatientWaitingQueue {
    private Queue<Patient> waitingQueue = new LinkedList<>();

    public void addPatient(Patient p) {
        waitingQueue.add(p);
    }

    public Patient nextPatient() {
        return waitingQueue.poll();
    }

    public int getTotalPatients() {
        return waitingQueue.size();
    }
}
