package Cau4;

public class App {
    public static void main(String[] args) {
        EmergencyQueue triage = new EmergencyQueue();

        triage.addPatient(new EmergencyPatient("BN01", "Nguyễn An", 2)); // Thường
        triage.addPatient(new EmergencyPatient("BN02", "Trần Bình", 1)); // CẤP CỨU
        triage.addPatient(new EmergencyPatient("BN03", "Lê Cường", 2)); // Thường
        triage.addPatient(new EmergencyPatient("BN04", "Phạm Dũng", 1)); // CẤP CỨU

        triage.displayQueue();

        System.out.println("\n--- BÁC SĨ GỌI BỆNH NHÂN ---");
        System.out.println("Mời bệnh nhân: " + triage.callNextPatient());
        System.out.println("Mời bệnh nhân: " + triage.callNextPatient());
        System.out.println("Mời bệnh nhân: " + triage.callNextPatient());
    }
}
