package Cau3;

import java.util.Stack;

public class MedicationProcessChecker {
    Stack<String> stack = new Stack<>();

    public boolean checkProcess(String[] actions) {
        // Reset stack trước khi kiểm tra quy trình mới
        reset();

        for(int i = 0; i < actions.length; i++) {
            String action = actions[i].toUpperCase();

            if(action.equals("PUSH")) {
                stack.push("Thuốc");
                System.out.println("Thao tác " + (i + 1) + ": PUSH - Đang phát thuốc");
            } else if(action.equals("POP")) {
                if(stack.isEmpty()) {
                    System.out.println("Lỗi: Chưa có đơn thuốc nào");
                    return false;
                }
                stack.pop();
                System.out.println("Thao tác " + (i + 1) + ": POP - Hoàn tất phát thuốc");
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Vẫn còn " + stack.size() + " đơn thuốc chưa hoàn tất!");
            return false;
        }

        return true;
    }

    public void reset(){
        stack.clear();
    }
}
