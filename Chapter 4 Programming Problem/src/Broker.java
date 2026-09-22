import java.util.Random;

public class Broker {

    private QueueInterface<Message> messageQueue;
    private Random random;

    public Broker() {
        messageQueue = new LinkedQueue<>();
        random = new Random();
    }

    public void addMessage(Message message) {
        try {
            messageQueue.enqueue(message);
        } catch (QueueOverflowException e) {
            System.out.println("Could not add message: " + e.getMessage());
        }
    }

    public void processBatch() {
        int batchSize = messageQueue.size();

        for (int i = 0; i < batchSize; i++) {
            try {
                Message message = messageQueue.dequeue();

                int roll = random.nextInt(100);

                if (roll < message.getSuccessChance()) {
                    System.out.println("SUCCESS: " + message);
                } else {
                    message.incrementRetryCount();
                    messageQueue.enqueue(message);
                    System.out.println("FAILED - Requeued: " + message);
                }

            } catch (QueueUnderflowException | QueueOverflowException e) {
                System.out.println("Queue error: " + e.getMessage());
            }
        }
    }

    public int getQueueSize() {
        return messageQueue.size();
    }
}