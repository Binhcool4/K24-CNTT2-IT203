package BTTH;

public abstract class Person {
    protected String id;
    protected String fullName;
    protected int age;

    public Person(String id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public abstract void showInfo(); // Phương thức trừu tượng
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
}
