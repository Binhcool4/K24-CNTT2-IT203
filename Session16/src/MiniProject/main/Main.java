package MiniProject.main;

import MiniProject.main.model.Customer;
import MiniProject.main.model.Pet;
import MiniProject.main.service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PetManager petManager = new PetManager();
        CustomerManager customerManager = new CustomerManager();
        SpaService spaService = new SpaService();
        ActivityLogger logger = new ActivityLogger();

        while (true) {
            System.out.println("""
                    ==== PET KINGDOM ====
                    1. Thêm thú cưng
                    2. Hiển thị thú cưng
                    3. Xóa thú cưng
                    4. Tìm thú cưng theo ID
                    5. Spa check-in
                    6. Phục vụ spa
                    7. Thêm khách hàng
                    8. Hiển thị khách hàng
                    9. Tìm khách hàng theo ID
                    10. Undo
                    0. Thoát
                    """);

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Loài: ");
                    String species = sc.nextLine();
                    System.out.print("Giá: ");
                    double price = Double.parseDouble(sc.nextLine());
                    Pet pet = new Pet(id, name, species, price);
                    boolean added = petManager.addPet(pet);
                    if (added) {
                        logger.log("Thêm thú cưng " + id);
                        System.out.println("Thêm thành công!");
                    }
                }
                case 2 -> petManager.getAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Nhập ID cần xóa: ");
                    String id = sc.nextLine();
                    petManager.deleteById(id);
                    logger.log("Xóa thú cưng " + id);
                }
                case 4 ->{
                    System.out.print("Nhập ID thú cưng: ");
                    String id = sc.nextLine().trim();

                    if (id.isBlank()) {
                        System.out.println("ID không được để trống!");
                        break;
                    }

                    Pet pet = petManager.findById(id);

                    if (pet != null) {
                        System.out.println("Tìm thấy: " + pet);
                    } else {
                        System.out.println("Không tìm thấy thú cưng.");
                    }
                }
                case 5 -> {
                    System.out.print("Nhập ID thú cưng: ");
                    String id = sc.nextLine();
                    Pet pet = petManager.findById(id);
                    if (pet != null) {
                        spaService.checkIn(pet);
                        logger.log("Check-in spa " + id);
                    }else{
                        logger.log("Id không tồn tại");
                    }
                }
                case 6 -> spaService.serveNext();
                case 7 -> {
                    System.out.print("ID KH: ");
                    String id = sc.nextLine().trim();

                    System.out.print("Tên: ");
                    String name = sc.nextLine().trim();

                    System.out.print("SĐT: ");
                    String phone = sc.nextLine().trim();

                    if (!phone.matches("\\d+")) {
                        System.out.println("SĐT phải là số!");
                        break;
                    }

                    boolean added = customerManager.addCustomer(new Customer(id, name, phone));
                    if (added) {
                        logger.log("Thêm khách hàng " + id);
                        System.out.println("Thêm thành công!");
                    }
                }
                case 8 -> customerManager.showAll();
                case 9 -> {
                    System.out.print("Nhập ID khách hàng: ");
                    String id = sc.nextLine().trim();

                    if (id.isBlank()) {
                        System.out.println("ID không được để trống!");
                        break;
                    }

                    Customer customer = customerManager.findById(id);

                    if (customer != null) {
                        System.out.println("Tìm thấy: " + customer);
                    } else {
                        System.out.println("Không tìm thấy khách hàng.");
                    }
                }
                case 10 -> logger.undo();
                case 0 -> System.exit(0);
            }
        }
    }
}