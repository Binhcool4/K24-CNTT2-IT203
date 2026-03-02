package Cau6;
import java.util.Stack;

public class MedicalRecordHistory {
    private Stack<EditAction> editStack = new Stack<>();
    private String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
    }

    public void addEditAction(EditAction action) {
        editStack.push(action);
    }

    public void displayHistory() {
        System.out.println("History for Record: " + recordId);
        for (int i = editStack.size() - 1; i >= 0; i--) {
            System.out.println(editStack.get(i));
        }
    }
}
