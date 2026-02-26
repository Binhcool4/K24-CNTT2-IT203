package BTTH;
import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println(">> Thêm bệnh nhân thành công.");
    }

    public void removePatient(int patientId) {
        boolean removed = patients.removeIf(p -> p.getId() == patientId);
        if (removed) {
            System.out.println(">> Đã xóa bệnh nhân ID: " + patientId);
        } else {
            System.out.println(">> Lỗi: Không tìm thấy ID bệnh nhân.");
        }
    }

    public void updatePatient(int patientId, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patientId) {
                patients.set(i, updatedPatient);
                System.out.println(">> Cập nhật thông tin thành công.");
                return;
            }
        }
        System.out.println(">> Không tìm thấy ID để cập nhật.");
    }

    public void searchPatientByName(String name) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println(">> Không tìm thấy bệnh nhân nào có tên: " + name);
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println(">> Danh sách bệnh nhân trống.");
        } else {
            System.out.println("--- DANH SÁCH BỆNH NHÂN HIỆN TẠI ---");
            patients.forEach(System.out::println);
        }
    }
}
