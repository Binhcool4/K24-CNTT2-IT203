package Cau5;

public class Patient {
    String name;
    int severity;
    String arrivalTime;

    public Patient(String name, int severity, String arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Bệnh nhân " + name + " (Mức " + severity + ", đến lúc " + arrivalTime + ")";
    }
}
