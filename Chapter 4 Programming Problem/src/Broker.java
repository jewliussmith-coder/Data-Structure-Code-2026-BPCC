import java.util.Random;

public class Broker {

    public static final int MAX_RETRIES = 3;

    private QueueInterface<Message> messageQueue;
    private QueueInterface<Message> deadLetterQueue;
    private Random random;

    public Broker() {
        messageQueue = new LinkedQueue<>();
        deadLetterQueue = new LinkedQueue<>();
        random = new Random();
    }

    public void addMessage(Message message) {
        try {
            messageQueue.enqueue(message);
            System.out.println("Message added to queue.");
        } catch (QueueOverflowException e) {
            System.out.println("Could not add message: " + e.getMessage());
        }
    }

    public void processBatch() {
        if (messageQueue.isEmpty()) {
            System.out.println("The message queue is empty.");
            return;
        }

        System.out.println("\nProcessing messages...");

        while (!messageQueue.isEmpty()) {
            try {
                Message message = messageQueue.dequeue();

                int roll = random.nextInt(100);

                if (roll < message.getSuccessChance()) {
                    System.out.println("SUCCESS: " + message);
                } else {
                    message.incrementRetryCount();

                    if (message.getRetryCount() >= MAX_RETRIES) {
                        deadLetterQueue.enqueue(message);
                        System.out.println("MOVED TO DLQ: " + message);
                    } else {
                        messageQueue.enqueue(message);
                        System.out.println("FAILED - Requeued: " + message);
                    }
                }

            } catch (QueueUnderflowException | QueueOverflowException e) {
                System.out.println("Queue error: " + e.getMessage());
            }
        }

        System.out.println("Batch processing complete.");
    }

    public void displayAndClearDLQ() {
        if (deadLetterQueue.isEmpty()) {
            System.out.println("\nDead-Letter Queue is empty.");
            return;
        }

        System.out.println("\nDead-Letter Queue:");

        while (!deadLetterQueue.isEmpty()) {
            try {
                Message message = deadLetterQueue.dequeue();
                System.out.println(message);
            } catch (QueueUnderflowException e) {
                System.out.println("Queue error: " + e.getMessage());
            }
        }

        System.out.println("Dead-Letter Queue has been cleared.");
    }

    public int getQueueSize() {
        return messageQueue.size();
    }

    public int getDLQSize() {
        return deadLetterQueue.size();
    }
}
