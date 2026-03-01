package BTTH;

public class MedicalRecord {
    private String recordId;
    private String diagnosis;
    private String date;

    public MedicalRecord(String recordId, String diagnosis, String date) {
        this.recordId = recordId;
        this.diagnosis = diagnosis;
        this.date = date;
    }

    public String getRecordId() { return recordId; }
    public String getDiagnosis() { return diagnosis; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return String.format("Mã HS: %s | Ngày: %s | Chẩn đoán: %s", recordId, date, diagnosis);
    }
}
