public interface QueueInterface<T> {
    boolean isEmpty();
    boolean isFull();
    void enqueue(T element) throws QueueOverflowException;
    T dequeue() throws QueueUnderflowException;
    T getFront() throws QueueUnderflowException;
}
