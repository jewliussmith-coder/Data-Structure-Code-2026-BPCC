public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        Message message1 = new Message("MSG001", "Hello World", 90);
        Message message2 = new Message("MSG002", "Process Payment", 50);
        Message message3 = new Message("MSG003", "Send Confirmation", 20);
        Message message4 = new Message("MSG004", "Update Database", 0);

        broker.addMessage(message1);
        broker.addMessage(message2);
        broker.addMessage(message3);
        broker.addMessage(message4);

        System.out.println("Queue size before processing: " + broker.getQueueSize());

        System.out.println("\nProcessing batch:");
        broker.processBatch();

        System.out.println("\nQueue size after processing: " + broker.getQueueSize());

        System.out.println("\nProcessing another batch:");
        broker.processBatch();

        System.out.println("\nQueue size after second batch: " + broker.getQueueSize());
    }
}
