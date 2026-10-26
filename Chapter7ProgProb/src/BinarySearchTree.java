
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
}
