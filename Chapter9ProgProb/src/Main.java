import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Company> market = new PriorityQueue<>();

        market.add(new Company("Disney", 25000));
        market.add(new Company("Oscorp", 18000));
        market.add(new Company("Rym Technologies", 42000));
        market.add(new Company("Roxxon Energy Corporation", 3500));
        market.add(new Company("Stark Industries", 30000));
        market.add(new Company("Cyberdyne Systems", 12000));
        market.add(new Company("Umbrella Corporation", 45000));
        market.add(new Company("Wonka Industries", 1000));
        market.add(new Company("Aperture Science", 8000));
        market.add(new Company("Oscorp", 20000));

        System.out.println("Company Market:");
        System.out.println(market);

        Company smallest = market.poll();

        System.out.println("\nSmallest Company:");
        System.out.println(smallest);

        market.add(smallest);

        System.out.println("\nCompany added back to the queue.");
        System.out.println("Queue size: " + market.size());
    }
}