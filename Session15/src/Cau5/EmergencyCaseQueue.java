package Cau5;
import java.util.*;

public class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>();

    public void addCase(EmergencyCase c) {
        cases.add(c);
        System.out.println("Đã tiếp nhận ca cấp cứu của BN: " + c.getPatientName());
    }

    public EmergencyCase getNextCase() {
        return cases.poll();
    }

    public boolean isEmpty() {
        return cases.isEmpty();
    }
}
