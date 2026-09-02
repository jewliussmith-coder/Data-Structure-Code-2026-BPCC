public class Stack<T> {
    private T[] items;
    private int top;

    public Stack() {
        items = (T[]) new Object[10];
        top = 0;
    }

    public void push(T item) {
        items[top] = item;
        top++;
    }

    public T pop() {
        top--;
        return items[top];
    }

    public T peek() {
        return items[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
