package Cau5;

public class App {
    public static void main(String[] args) {
        EmergencyCaseQueue clinicQueue = new EmergencyCaseQueue();

        clinicQueue.addCase(new EmergencyCase("Nguyễn Văn An"));
        clinicQueue.addCase(new EmergencyCase("Trần Thị Bình"));

        EmergencyCase currentCase = clinicQueue.getNextCase();

        if (currentCase != null) {
            currentCase.addStep(new TreatmentStep("Tiếp nhận & Đo huyết áp", "08:00"));
            currentCase.addStep(new TreatmentStep("Xét nghiệm máu", "08:15"));
            currentCase.addStep(new TreatmentStep("Chẩn đoán: Sốt xuất huyết", "08:30"));

            currentCase.displaySteps();

            System.out.println("\n* Phát hiện chẩn đoán nhầm, đang hoàn tác bước cuối...");
            TreatmentStep undone = currentCase.undoStep();
            System.out.println("  Đã hủy bước: " + undone);

            currentCase.displaySteps();
        }
    }
}
