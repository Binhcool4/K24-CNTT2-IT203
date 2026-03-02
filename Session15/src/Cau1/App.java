package Cau1;

public class App {
    public static void main(String[] args) {
        MedicalRecordHistory manager = new MedicalRecordHistory();

        manager.addEdit(new EditAction("Thay đổi liều lượng thuốc", "08:00"));
        manager.addEdit(new EditAction("Cập nhật nhịp tim", "08:05"));
        manager.addEdit(new EditAction("Thêm chẩn đoán phụ", "08:10"));

        manager.displayHistory();

        System.out.println("\nChỉnh sửa gần nhất: " + manager.getLatestEdit());

        System.out.println("\nThực hiện hoàn tác");
        EditAction undone = manager.undoEdit();
        if (undone != null) {
            System.out.println("Đã hoàn tác: " + undone);
        }

        System.out.println("\nSau khi Undo:");
        manager.displayHistory();
    }
}
