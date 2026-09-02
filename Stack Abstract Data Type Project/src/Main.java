public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        // Test isEmpty()
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Test push()
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        // Test peek()
        System.out.println("Top item: " + stack.peek());

        // Test pop() - LIFO
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Test isEmpty() again
        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}
