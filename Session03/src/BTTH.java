import java.util.Scanner;

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ids = new int[100];
        String[] titles = new String[100];
        int[] quantities = new int[100];

        int count = 0; // số sách hiện có

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Xem danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Cập nhật số lượng");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Sắp xếp theo số lượng (giảm dần)");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // xóa bộ nhớ đệm

            switch (choice) {
                case 1:
                    // Xem danh sách
                    if (count == 0) {
                        System.out.println("Danh sách trống!");
                        break;
                    }
                    System.out.printf("%-10s %-30s %-10s\n", "Mã", "Tên sách", "Số lượng");
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%-10d %-30s %-10d\n", ids[i], titles[i], quantities[i]);
                    }
                    break;

                case 2:
                    // Thêm sách mới
                    if (count == 100) {
                        System.out.println("Mảng đã đầy, không thể thêm!");
                        break;
                    }

                    System.out.print("Nhập mã sách: ");
                    int newId = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;
                    for (int i = 0; i < count; i++) {
                        if (ids[i] == newId) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Mã sách đã tồn tại!");
                        break;
                    }

                    System.out.print("Nhập tên sách: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Nhập số lượng: ");
                    int newQuantity = sc.nextInt();

                    ids[count] = newId;
                    titles[count] = newTitle;
                    quantities[count] = newQuantity;
                    count++;

                    System.out.println("Thêm sách thành công!");
                    break;

                case 3:
                    // Cập nhật số lượng
                    System.out.print("Nhập mã sách cần cập nhật: ");
                    int updateId = sc.nextInt();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (ids[i] == updateId) {
                            System.out.print("Nhập số lượng mới: ");
                            quantities[i] = sc.nextInt();
                            found = true;
                            System.out.println("Cập nhật thành công!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sách!");
                    }
                    break;

                case 4:
                    // Xóa sách
                    System.out.print("Nhập mã sách cần xóa: ");
                    int deleteId = sc.nextInt();

                    int index = -1;
                    for (int i = 0; i < count; i++) {
                        if (ids[i] == deleteId) {
                            index = i;
                            break;
                        }
                    }

                    if (index == -1) {
                        System.out.println("Không tìm thấy sách!");
                        break;
                    }

                    // Dồn mảng
                    for (int i = index; i < count - 1; i++) {
                        ids[i] = ids[i + 1];
                        titles[i] = titles[i + 1];
                        quantities[i] = quantities[i + 1];
                    }
                    count--;

                    System.out.println("Xóa sách thành công!");
                    break;

                case 5:
                    // Tìm kiếm gần đúng
                    System.out.print("Nhập từ khóa: ");
                    String keyword = sc.nextLine().toLowerCase();

                    boolean hasResult = false;
                    for (int i = 0; i < count; i++) {
                        if (titles[i].toLowerCase().contains(keyword)) {
                            System.out.printf("%-10d %-30s %-10d\n", ids[i], titles[i], quantities[i]);
                            hasResult = true;
                        }
                    }

                    if (!hasResult) {
                        System.out.println("Không có sách phù hợp!");
                    }
                    break;

                case 6:
                    // Sắp xếp giảm dần theo số lượng
                    for (int i = 0; i < count - 1; i++) {
                        for (int j = i + 1; j < count; j++) {
                            if (quantities[i] < quantities[j]) {
                                // đổi chỗ cả 3 mảng
                                int tempQ = quantities[i];
                                quantities[i] = quantities[j];
                                quantities[j] = tempQ;

                                int tempId = ids[i];
                                ids[i] = ids[j];
                                ids[j] = tempId;

                                String tempTitle = titles[i];
                                titles[i] = titles[j];
                                titles[j] = tempTitle;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong!");
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}