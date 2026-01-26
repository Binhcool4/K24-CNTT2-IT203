import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int age, bookNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so tuoi cua ban: ");
        age = scanner.nextInt();
        System.out.print("Nhap so sach dang muon: ");
        bookNumber = scanner.nextInt();
        if (age >= 18 && bookNumber <= 3) {
            System.out.print("Ket qua: Ban du DIEU KIEN de muon sach quy hiem");
        } else {
            System.out.println("Ket qua: Khong du dieu kien");
            if (age < 18) {
                System.out.print("- Ly do:: Ban phai tu 18 tuoi tro len.");
            }
            if (bookNumber > 3) {
                System.out.print("- Ly do: Ban da muon toi da 3 cuon");
            }
        }
    }
}