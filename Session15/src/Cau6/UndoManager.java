package Cau6;
import java.util.Stack;

public class UndoManager {
    Stack<InputAction> undoStack = new Stack<>();
    int maxUndoSteps;

    public UndoManager(int maxUndoSteps) {
        this.maxUndoSteps = maxUndoSteps;
    }

    public void recordAction(InputAction action) {
        if (undoStack.size() >= maxUndoSteps) {
            undoStack.remove(0);
        }
        undoStack.push(action);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            InputAction last = undoStack.pop();
            System.out.println("Undo field [" + last.fieldName + "] to value: " + last.oldValue);
        } else {
            System.out.println("Nothing to undo");
        }
    }
}
