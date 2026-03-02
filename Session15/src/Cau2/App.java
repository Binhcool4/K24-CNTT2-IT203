package Cau2;

public class App {
    public static void main(String[] args) {
        PatientQueue clinic = new PatientQueue();

        clinic.addPatient(new Patient("BN01", "Nguyễn Văn An", 25));
        clinic.addPatient(new Patient("BN02", "Trần Thị Bình", 30));
        clinic.addPatient(new Patient("BN03", "Lê Văn Cường", 45));

        clinic.displayQueue();

        System.out.println("Bệnh nhân tiếp theo sẽ được khám: " + clinic.peekNextPatient());

        Patient p1 = clinic.callNextPatient();
        if (p1 != null) System.out.println("Đang khám cho: " + p1);

        clinic.displayQueue();
    }
}
