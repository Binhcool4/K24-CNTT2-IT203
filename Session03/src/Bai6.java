import java.util.Arrays;

public class Bai6 {
    public static void main(String[] args) {
        int[] arrayFirst = {1, 3, 5, 7, 9};
        int[] arraySecond = {2, 3, 5, 6, 8, 9, 10};

        System.out.println("Kho cũ: " + Arrays.toString(arrayFirst));
        System.out.println("Lô mới: " + Arrays.toString(arraySecond));

        int[] arrayMerge = mergeBooks(arrayFirst, arraySecond);

        System.out.println("Kho tổng (đã gộp & lọc trùng): " + Arrays.toString(arrayMerge));
    }

    public static int[] mergeBooks(int[] a, int[] b) {
        int[] temp = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else if (a[i] > b[j]) {
                temp[k++] = b[j++];
            } else {
                temp[k++] = a[i++];
                j++;
            }
        }

        while (i < a.length) {
            temp[k++] = a[i++];
        }

        while (j < b.length) {
            temp[k++] = b[j++];
        }

        return Arrays.copyOf(temp, k);
    }
}