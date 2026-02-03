package project.mini;

public class StudentManager {
    private Student[] students;
    private int count;

    public StudentManager(int size) {
        students = new Student[size];
        count = 0;
    }

    /* ========== ADD ========== */
    public boolean addStudent(Student s) {
        if (count >= students.length || findById(s.getId()) != null) {
            return false;
        }
        students[count++] = s;
        return true;
    }

    /* ========== DISPLAY ========== */
    public void displayAll() {
        if (count == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.printf("%-8s %-20s %-5s %-8s %-6s %-10s\n",
                "Mã SV", "Họ tên", "Tuổi", "GT", "ĐTB", "Xếp loại");
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    /* ========== SEARCH ========== */
    public Student findById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                return students[i];
            }
        }
        return null;
    }

    public void searchByName(String keyword) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getName().toLowerCase().contains(keyword.toLowerCase())) {
                students[i].display();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sinh viên!");
    }

    /* ========== DELETE ========== */
    public boolean delete(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                return true;
            }
        }
        return false;
    }

    /* ========== SORT ========== */
    public void sortByAvgDesc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (students[j].getAvg() < students[j + 1].getAvg()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public void sortByNameAZ() {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (students[j].getName()
                        .compareToIgnoreCase(students[min].getName()) < 0) {
                    min = j;
                }
            }
            Student temp = students[i];
            students[i] = students[min];
            students[min] = temp;
        }
    }

    /* ========== STATISTIC ========== */
    public void statistic() {
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        Student max = students[0], min = students[0];
        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum += students[i].getAvg();

            switch (students[i].getRank()) {
                case "Giỏi": gioi++; break;
                case "Khá": kha++; break;
                case "Trung bình": tb++; break;
                default: yeu++;
            }

            if (students[i].getAvg() > max.getAvg()) max = students[i];
            if (students[i].getAvg() < min.getAvg()) min = students[i];
        }

        System.out.println("Giỏi: " + gioi);
        System.out.println("Khá: " + kha);
        System.out.println("Trung bình: " + tb);
        System.out.println("Yếu: " + yeu);
        System.out.printf("Điểm TB chung: %.2f\n", sum / count);
        System.out.println("SV cao điểm nhất: " + max.getName());
        System.out.println("SV thấp điểm nhất: " + min.getName());
    }
}
