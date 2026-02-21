package Bai3;

public class Duck extends Animal implements Swimmable, Flyable {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " đang bơi tung tăng trên mặt hồ.");
    }

    @Override
    public void fly() {
        System.out.println(name + " đang đập cánh bay lên trời.");
    }
}
