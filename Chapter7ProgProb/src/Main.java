public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> archive = new BinarySearchTree<>();

        int[] sampleIds = {50, 25, 75, 10, 30, 60, 85};

        for (int id : sampleIds) {
            archive.add(id);
        }

        System.out.println("Archive initialized with sample IDs.");
        System.out.println("Tree height: " + archive.height());

        System.out.print("Inorder: ");
        archive.inOrderTraversal();

        System.out.print("Preorder: ");
        archive.preOrderTraversal();
    }
}
