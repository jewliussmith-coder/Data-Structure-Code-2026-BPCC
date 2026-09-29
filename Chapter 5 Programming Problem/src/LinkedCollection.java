public class LinkedCollection<T> implements CollectionInterface<T> {
    private LLNode<T> head;
    private int numElements;

    public LinkedCollection() {
        head = null;
        numElements = 0;
    }

    private LLNode<T> find(T target) {
        LLNode<T> location = head;

        while (location != null) {
            if (location.getInfo().equals(target))
                return location;

            location = location.getLink();
        }

        return null;
    }

    @Override
    public boolean add(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        newNode.setLink(head);
        head = newNode;
        numElements++;
        return true;
    }

    @Override
    public T get(T target) {
        LLNode<T> location = find(target);
        return location == null ? null : location.getInfo();
    }

    @Override
    public boolean contains(T target) {
        return find(target) != null;
    }

    @Override
    public boolean remove(T target) {
        LLNode<T> location = head;
        LLNode<T> previous = null;

        while (location != null && !location.getInfo().equals(target)) {
            previous = location;
            location = location.getLink();
        }

        if (location == null)
            return false;

        if (location == head)
            head = head.getLink();
        else
            previous.setLink(location.getLink());

        numElements--;
        return true;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LLNode<T> current = head;

        while (current != null) {
            result.append(current.getInfo()).append("\n");
            current = current.getLink();
        }

        return result.toString();
    }
}