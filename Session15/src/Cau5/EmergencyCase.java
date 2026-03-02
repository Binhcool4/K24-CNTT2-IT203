package Cau5;
import java.util.*;

public class EmergencyCase {
    private String patientName;
    private Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(String patientName) {
        this.patientName = patientName;
    }

    public void addStep(TreatmentStep step) {
        steps.push(step);
    }

    public TreatmentStep undoStep() {
        if (!steps.isEmpty()) {
            return steps.pop();
        }
        return null;
    }

    public void displaySteps() {
        System.out.println("Lịch sử điều trị của BN " + patientName + ":");
        if (steps.isEmpty()) System.out.println("  (Trống)");
        else steps.forEach(System.out::println);
    }

    public String getPatientName() { return patientName; }
}
