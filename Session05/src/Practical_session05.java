import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Menu chạy lặp cho đến khi người dùng chọn 0
        do {
            showMenu();
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình. Bye 👋");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }

            System.out.println();
        } while (choice != 0);
    }

    // ================= MENU =================
    static void showMenu() {
        System.out.println("===== MENU THUẬT TOÁN =====");
        System.out.println("1. Two Sum (Tìm cặp số có tổng bằng K)");
        System.out.println("2. Move Zeroes (Dồn số 0 về cuối)");
        System.out.println("3. Valid Palindrome (Chuỗi đối xứng)");
        System.out.println("4. Reverse Words (Đảo ngược từ)");
        System.out.println("5. Happy Number (Số hạnh phúc)");
        System.out.println("0. Thoát");
    }

    // ================= FR1: TWO SUM =================
    static void twoSum() {
        System.out.print("Nhập số phần tử mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Nhập target: ");
        int target = Integer.parseInt(sc.nextLine());

        // Duyệt 2 vòng lặp để tìm cặp tổng = target
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Tìm thấy tại chỉ số: " + i + " và " + j);
                    return;
                }
            }
        }

        System.out.println("Không tìm thấy cặp số phù hợp.");
    }

    // ================= FR2: MOVE ZEROES =================
    static void moveZeroes() {
        System.out.print("Nhập số phần tử mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int index = 0; // vị trí ghi số khác 0

        // Đưa các số khác 0 lên đầu
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // Ghi 0 vào các vị trí còn lại
        while (index < n) {
            arr[index++] = 0;
        }

        System.out.print("Mảng sau khi xử lý: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // ================= FR3: VALID PALINDROME =================
    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        // Xóa ký tự không phải chữ cái & số, chuyển về chữ thường
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        // Two pointers kiểm tra đối xứng
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println("False (Không phải chuỗi đối xứng)");
                return;
            }
            left++;
            right--;
        }

        System.out.println("True (Chuỗi đối xứng)");
    }

    // ================= FR4: REVERSE WORDS =================
    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        // Xóa khoảng trắng thừa
        s = s.trim();
        if (s.length() == 0) {
            System.out.println("Chuỗi rỗng.");
            return;
        }

        // Tách từ bằng regex
        String[] words = s.split("\\s+");

        // Đảo ngược thứ tự từ
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i != 0) result += " ";
        }

        System.out.println("Kết quả: " + result);
    }

    // ================= FR5: HAPPY NUMBER =================
    static void happyNumber() {
        System.out.print("Nhập số n: ");
        int n = Integer.parseInt(sc.nextLine());

        int slow = n;
        int fast = n;

        // Dùng kỹ thuật phát hiện vòng lặp
        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            System.out.println("Đây là số hạnh phúc 😊");
        } else {
            System.out.println("Không phải số hạnh phúc 😢");
        }
    }

    // Tính tổng bình phương các chữ số
    static int sumSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
