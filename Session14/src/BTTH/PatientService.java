package BTTH;
import java.util.*;

public class PatientService implements Manageable<Patient> {
    private Set<Patient> patients = new HashSet<>();
    private Map<String, List<MedicalRecord>> recordMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void add(Patient p) {
        if (patients.contains(p)) {
            System.out.println("Mã bệnh nhân đã tồn tại");
        } else {
            patients.add(p);
            System.out.println("Thêm bệnh nhân thành công");
        }
    }

    @Override
    public void update(String id) {
        Patient p = findById(id);
        if (p != null) {
            System.out.print("Tên mới: "); p.setName(sc.nextLine());
            System.out.print("Tuổi mới: "); p.setAge(Integer.parseInt(sc.nextLine()));
            System.out.print("SĐT mới: "); p.setPhone(sc.nextLine());
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Không tìm thấy bệnh nhân");
        }
    }

    @Override
    public void delete(String id) {
        Patient p = findById(id);
        if (p != null) {
            patients.remove(p);
            recordMap.remove(id);
            System.out.println("Đã xóa bệnh nhân");
        } else {
            System.out.println("Không tìm thấy bệnh nhân");
        }
    }

    @Override
    public void displayAll() {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-5s | %-20s | %-5s | %-12s |\n", "ID", "Họ Tên", "Tuổi", "SĐT");
        for (Patient p : patients) p.displayInfo();
    }

    public void addRecord(String patientId, MedicalRecord record) {
        if (findById(patientId) == null) {
            System.out.println("Bệnh nhân không tồn tại");
            return;
        }
        recordMap.computeIfAbsent(patientId, k -> new ArrayList<>()).add(record);
        System.out.println("Đã thêm hồ sơ khám");
    }

    public void viewRecords(String patientId) {
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list == null || list.isEmpty()) {
            System.out.println("Chưa có hồ sơ khám cho bệnh nhân này");
        } else {
            list.forEach(System.out::println);
        }
    }

    public Patient findById(String id) {
        return patients.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void sortByName() {
        List<Patient> list = new ArrayList<>(patients);
        Collections.sort(list);
        list.forEach(Patient::displayInfo);
    }

    public void sortByAge() {
        List<Patient> list = new ArrayList<>(patients);
        list.sort((a, b) -> Integer.compare(a.getAge(), b.getAge())); // Comparator
        list.forEach(Patient::displayInfo);
    }

    public void deleteRecord(String patientId, String recordId) {
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list != null) {
            boolean removed = list.removeIf(r -> r.getRecordId().equals(recordId));
            if (removed) System.out.println("Đã xóa hồ sơ " + recordId);
            else System.out.println("Không tìm thấy mã hồ sơ này.");
        } else {
            System.out.println("Bệnh nhân không có hồ sơ nào.");
        }
    }

    public void sortPatients(int type) {
        List<Patient> list = new ArrayList<>(patients);
        if (type == 1) {
            Collections.sort(list);
        } else if (type == 2) {
            list.sort((a, b) -> Integer.compare(a.getAge(), b.getAge())); // Comparator Tuổi
        } else {
            list.sort((a, b) -> a.getId().compareTo(b.getId())); // Comparator ID
        }
        System.out.println("--- DANH SÁCH SAU KHI SẮP XẾP ---");
        list.forEach(Patient::displayInfo);
    }
}
