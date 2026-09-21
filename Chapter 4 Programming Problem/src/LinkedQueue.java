public class LinkedQueue<T> implements QueueInterface<T> {

    private LLNode<T> front;
    private LLNode<T> rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        LLNode<T> newNode = new LLNode<>(element);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setLink(newNode);
            rear = newNode;
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T element = front.getInfo();
        front = front.getLink();

        if (front == null) {
            rear = null;
        }

        return element;
    }

    @Override
    public T getFront() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        return front.getInfo();
    }
}