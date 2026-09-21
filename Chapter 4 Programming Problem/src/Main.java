public class Main {
    public static void main(String[] args) {
        LinkedQueue<Message> messageQueue = new LinkedQueue<>();

        Message message1 = new Message("MSG001", "Hello World");
        Message message2 = new Message("MSG002", "Process Payment");
        Message message3 = new Message("MSG003", "Send Confirmation");

        try {
            messageQueue.enqueue(message1);
            messageQueue.enqueue(message2);
            messageQueue.enqueue(message3);

            System.out.println("Dequeuing messages:");

            System.out.println(messageQueue.dequeue());
            System.out.println(messageQueue.dequeue());
            System.out.println(messageQueue.dequeue());

        } catch (QueueOverflowException | QueueUnderflowException e) {
            System.out.println("Queue error: " + e.getMessage());
        }
    }
}