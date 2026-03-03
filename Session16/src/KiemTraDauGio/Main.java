package KiemTraDauGio;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ProductRepository repo = new ProductRepository();

        // Thêm sản phẩm
        repo.add(new ElectronicProduct("E01", "Laptop", 5000000, 24));
        repo.add(new ElectronicProduct("E02", "Headphone", 200000, 6));
        repo.add(new FoodProduct("F01", "Milk", 30000, 10));
        repo.add(new FoodProduct("F02", "Cake", 50000, 20));

        // Hiển thị toàn bộ sản phẩm
        System.out.println("===== PRODUCT LIST =====");
        for (Product p : repo.findAll()) {
            if (p != null) {
                p.displayInfo();
                System.out.println("Final Price: " + p.calculateFinalPrice());
                System.out.println("----------------------");
            }
        }

        // Tìm theo ID
        System.out.println("===== FIND PRODUCT E01 =====");
        Product found = repo.findById("E01");
        if (found != null) {
            found.displayInfo();
            System.out.println("Final Price: " + found.calculateFinalPrice());
        } else {
            System.out.println("Product not found!");
        }

        // Sắp xếp theo giá tăng dần
        List<Product> sortedList = repo.findAll();
        Collections.sort(sortedList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("===== SORTED BY PRICE ASC =====");
        for (Product p : sortedList) {
            System.out.println(p.getId() + " - " + p.getPrice());
        }

        // Thống kê theo loại
        System.out.println("===== COUNT BY TYPE =====");
        Map<String, Integer> stats = repo.countByType();
        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}