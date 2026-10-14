import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList implements Iterable<Song> {

    private class Node {
        Song data;
        Node next;

        Node(Song data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void addLast(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    @Override
    public Iterator<Song> iterator() {
        return new Iterator<Song>() {
            private Node current = head;
            private Node previous = null;
            private Node lastReturned = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Song next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                previous = lastReturned;
                lastReturned = current;

                Song data = current.data;
                current = current.next;

                return data;
            }

            @Override
            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException("Cannot call remove() before next() or after a previous remove().");
                }

                if (previous == null) {
                    head = current;
                    if (head == null) {
                        tail = null;
                    }
                } else {
                   previous.next = current;
                    if (current == null) {
                        tail = previous;
                    }
                }

              lastReturned = null;
            }
        };
    }
}

