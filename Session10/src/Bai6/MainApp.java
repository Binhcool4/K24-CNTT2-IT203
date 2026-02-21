package Bai6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("iPhone 15", 22000000));
        products.add(new Product("MacBook M3", 35000000));
        products.add(new Product("AirPods Pro", 5000000));
        products.add(new Product("Apple Watch", 12000000));

        // 1. Sắp xếp theo GIÁ TĂNG DẦN bằng ANONYMOUS CLASS
        // Phù hợp khi logic phức tạp hoặc cần biến nội bộ (xem ghi chú dưới)
        Collections.sort(products, new Comparator<Product>() {
            private int callCount = 0; // Anonymous Class có thể chứa thuộc tính riêng

            @Override
            public int compare(Product p1, Product p2) {
                callCount++;
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("--- Sắp xếp theo GIÁ (Anonymous Class) ---");
        products.forEach(System.out::println);

        // 2. Sắp xếp theo TÊN (A-Z) bằng LAMBDA EXPRESSION
        // Cực kỳ ngắn gọn, dùng cho Functional Interface (chỉ có 1 phương thức trừu tượng)
        Collections.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        System.out.println("\n--- Sắp xếp theo TÊN (Lambda Expression) ---");
        products.forEach(System.out::println);
    }
}
