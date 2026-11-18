public class Main {

    public static void main(String[] args) {
        int[] values = Sorts.initValues(50);

        System.out.println("Original Array:");
        Sorts.printValues(values);

        Sorts.selectionSort(values);

        System.out.println("Sorted Array:");
        Sorts.printValues(values);

        System.out.println("Is the array sorted? " + Sorts.isSorted(values));
    }
}
