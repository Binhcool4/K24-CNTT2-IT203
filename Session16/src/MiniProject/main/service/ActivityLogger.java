package MiniProject.main.service;

import java.util.Stack;

public class ActivityLogger {
    private Stack<String> stack = new Stack<>();

    public void log(String action) {
        stack.push(action);
    }

    public void undo() {
        if (!stack.isEmpty()) {
            System.out.println("Undo: " + stack.pop());
        } else {
            System.out.println("Không có thao tác để undo.");
        }
    }

    public void showLogs() {
        for (String s : stack) {
            System.out.println(s);
        }
    }
}