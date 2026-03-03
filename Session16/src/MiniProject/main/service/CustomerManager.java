package MiniProject.main.service;

import MiniProject.main.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    private Map<String, Customer> customerMap = new HashMap<>();

    public boolean addCustomer(Customer customer) {

        if (customer.getId().isBlank()) {
            System.out.println("ID không được để trống!");
            return false;
        }

        if (customerMap.containsKey(customer.getId())) {
            System.out.println("ID đã tồn tại!");
            return false;
        }

        // Kiểm tra trùng SĐT
        for (Customer c : customerMap.values()) {
            if (c.getPhone().equals(customer.getPhone())) {
                System.out.println("Số điện thoại đã tồn tại!");
                return false;
            }
        }

        customerMap.put(customer.getId(), customer);
        return true;
    }

    public Customer findById(String id) {
        return customerMap.get(id);
    }

    public void showAll() {
        if (customerMap.isEmpty()) {
            System.out.println("Danh sách khách hàng trống.");
            return;
        }

        System.out.println("===== DANH SÁCH KHÁCH HÀNG =====");
        for (Customer c : customerMap.values()) {
            System.out.println(c);
        }
    }
}