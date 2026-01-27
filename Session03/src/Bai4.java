public class Bai4 {
    public static void main(String[] args) {
        int[] isbnList = {105, 102, 109, 101, 103};

        System.out.print("TRƯỚC KHI SẮP XẾP: ");
        displayBooks(isbnList);

        sortBooks(isbnList);

        System.out.print("SAU KHI SẮP XẾP: ");
        displayBooks(isbnList);
    }

    public static void sortBooks(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void displayBooks(int[] arr) {
        for (int isbn : arr) {
            System.out.print(isbn + " ");
        }
        System.out.println();
    }
}