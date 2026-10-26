public class BinarySearchTree<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(T element) {
        root = recAdd(element, root);
    }

    private BSTNode<T> recAdd(T element, BSTNode<T> node) {
        if (node == null) {
            return new BSTNode<>(element);
        }

        if (element.compareTo(node.getInfo()) <= 0) {
            node.setLeft(recAdd(element, node.getLeft()));
        } else {
            node.setRight(recAdd(element, node.getRight()));
        }

        return node;
    }

    public int height() {
        return recHeight(root);
    }

    private int recHeight(BSTNode<T> node) {
        if (node == null) {
            return -1;
        }
        return Math.max(recHeight(node.getLeft()), recHeight(node.getRight())) + 1;
    }

    public void inOrderTraversal() {
        recInOrder(root);
        System.out.println();
    }

    private void recInOrder(BSTNode<T> node) {
        if (node == null) {
            return;
        }
        recInOrder(node.getLeft());
        System.out.print(node.getInfo() + " ");
        recInOrder(node.getRight());
    }

    public void preOrderTraversal() {
        recPreOrder(root);
        System.out.println();
    }

    private void recPreOrder(BSTNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getInfo() + " ");
        recPreOrder(node.getLeft());
        recPreOrder(node.getRight());
    }
}
