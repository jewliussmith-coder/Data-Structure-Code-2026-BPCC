public class Main {
    public static void main(String[] args) {
        // Test Case 1: Empty Tree
        BinarySearchTree<Integer> emptyArchive = new BinarySearchTree<>();
        System.out.println("--- Empty Tree Test ---");
        System.out.println("Height: " + emptyArchive.height());
        System.out.print("Inorder: ");
        emptyArchive.inOrderTraversal();
        System.out.print("Preorder: ");
        emptyArchive.preOrderTraversal();

        // Test Case 2: Single-Node Tree
        BinarySearchTree<Integer> singleArchive = new BinarySearchTree<>();
        singleArchive.add(42);
        System.out.println("\n--- Single-Node Tree Test ---");
        System.out.println("Height: " + singleArchive.height());
        System.out.print("Inorder: ");
        singleArchive.inOrderTraversal();
        System.out.print("Preorder: ");
        singleArchive.preOrderTraversal();

        // Test Case 3: Initial Balanced Sample Dataset
        BinarySearchTree<Integer> sampleArchive = new BinarySearchTree<>();
        int[] sampleIds = {50, 25, 75, 10, 30, 60, 85};
        for (int id : sampleIds) {
            sampleArchive.add(id);
        }
        System.out.println("\n--- Balanced Sample Dataset ---");
        System.out.println("Height: " + sampleArchive.height());
        System.out.print("Inorder: ");
        sampleArchive.inOrderTraversal();
        System.out.print("Preorder: ");
        sampleArchive.preOrderTraversal();

        // Test Case 4: Skewed Tree (Already-Sorted Data)
        BinarySearchTree<Integer> skewedArchive = new BinarySearchTree<>();
        int[] sortedIds = {10, 20, 30, 40};
        for (int id : sortedIds) {
            skewedArchive.add(id);
        }
        System.out.println("\n--- Skewed Sorted Dataset ---");
        System.out.println("Height: " + skewedArchive.height());
        System.out.print("Inorder: ");
        skewedArchive.inOrderTraversal();
        System.out.print("Preorder: ");
        skewedArchive.preOrderTraversal();
    }
}
