package BTTH;

abstract class Person {
    protected String id;
    protected String name;
    protected int age;

    public abstract void displayInfo();

    // Cần Getter cho Comparator
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
}
