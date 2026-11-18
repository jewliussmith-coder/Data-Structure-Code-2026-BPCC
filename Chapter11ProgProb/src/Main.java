public class Main {

    public static void main(String[] args) {

        int[] sizes = {10000, 1000000};

        for (int size : sizes) {

            System.out.println("\nTesting array size: " + size);

            int[] original = Sorts.initValues(size);

            int[] selectionValues = original.clone();
            int[] mergeValues = original.clone();

            if (size == 10000) {
                long start = System.currentTimeMillis();

                Sorts.selectionSort(selectionValues);

                long end = System.currentTimeMillis();

                System.out.println("Selection Sort: " + (end - start) + " ms");
                System.out.println("Selection Sort Correct: "
                        + Sorts.isSorted(selectionValues));
            } else {
                System.out.println("Selection Sort skipped because "
                        + "1,000,000 elements would take too long.");
            }

            long start = System.currentTimeMillis();

            Sorts.mergeSort(mergeValues);

            long end = System.currentTimeMillis();

            System.out.println("Merge Sort: " + (end - start) + " ms");
            System.out.println("Merge Sort Correct: "
                    + Sorts.isSorted(mergeValues));
        }

        testEdgeCases();
    }

    public static void testEdgeCases() {

        System.out.println("\n--- Edge Case Testing ---");

        int[][] testArrays = {
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {7, 7, 7, 7, 7}
        };

        String[] testNames = {
                "Already Sorted",
                "Reverse Sorted",
                "Identical Values"
        };

        for (int i = 0; i < testArrays.length; i++) {

            int[] selectionValues = testArrays[i].clone();
            int[] mergeValues = testArrays[i].clone();

            Sorts.selectionSort(selectionValues);
            Sorts.mergeSort(mergeValues);

            System.out.println(testNames[i]);
            System.out.println("Selection Sort: "
                    + Sorts.isSorted(selectionValues));
            System.out.println("Merge Sort: "
                    + Sorts.isSorted(mergeValues));
        }
    }
}
