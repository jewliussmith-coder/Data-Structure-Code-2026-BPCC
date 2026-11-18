import java.util.Random;

public class Sorts {

    public static int[] initValues(int size) {
        int[] values = new int[size];
        Random random = new Random();

        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(1001);
        }

        return values;
    }

    public static boolean isSorted(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] > values[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void swap(int[] values, int indexOne, int indexTwo) {
        int temp = values[indexOne];
        values[indexOne] = values[indexTwo];
        values[indexTwo] = temp;
    }

    public static void printValues(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");

            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static int minIndex(int[] values, int start, int end) {
        int min = start;

        for (int i = start + 1; i <= end; i++) {
            if (values[i] < values[min]) {
                min = i;
            }
        }

        return min;
    }

    public static void selectionSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int min = minIndex(values, i, values.length - 1);
            swap(values, i, min);
        }
    }
}
