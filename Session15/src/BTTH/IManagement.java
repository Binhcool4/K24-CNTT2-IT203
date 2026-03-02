package BTTH;

public interface IManagement<T> {
    void add(T t);
    void display();
    T search(String id);
    void sort();
}
