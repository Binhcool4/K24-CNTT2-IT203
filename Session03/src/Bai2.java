import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] books = {"Conan", "Doraemon", "Shin", "Dragon Ball", "Pokemon"};

        System.out.print("Nhập tên sách cần tìm: ");
        String search = sc.nextLine();

        int i = searchBooks(books, search);
        if(i == -1){
            System.out.println("Sách không tồn tại trong thư viện");
        } else {
            System.out.println("Tìm thấy sách " + search + "tại ví trí số: " + i);
        }
    }

    public static int searchBooks(String[] arr, String search) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(search)) {
                return i;
            }
        }
        return -1;
    }
}