package BTTH;

import java.util.Objects;

public class Patient extends Person implements Comparable<Patient> {
    private String phone;

    public Patient(String id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public int compareTo(Patient o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public void displayInfo() {
        System.out.printf("| %-5s | %-20s | %-5d | %-12s |\n", id, name, age, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPhone(String phone) { this.phone = phone; }
}
