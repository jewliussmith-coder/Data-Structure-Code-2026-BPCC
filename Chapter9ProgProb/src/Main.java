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
        market.add(new Company("Oscorp TWO", 20000));

        int mergerCount = 0;
        int titanThreshold = 500000;
        Company titan = null;

        System.out.println("Starting Company Market:");
        System.out.println(market);

        while (market.size() >= 2) {

            Company companyA = market.poll();
            Company companyB = market.poll();

            int newSize = (int) ((companyA.getSize() + companyB.getSize()) * 1.1);

            String newName = companyA.getName() + "-" + companyB.getName();

            Company mergedCompany = new Company(newName, newSize);

            mergerCount++;

            System.out.println("\nMerger: " + companyA.getName()
                    + " and " + companyB.getName()
                    + " have merged into " + mergedCompany.getName()
                    + " with size " + mergedCompany.getSize() + "!");

            if (mergedCompany.getSize() >= titanThreshold) {
                titan = mergedCompany;
                break;
            }

            market.add(mergedCompany);
        }

        System.out.println("\n=== Final Market Report =====");

        if (titan != null) {
            System.out.println("Industry Titan: " + titan);
        } else {
            System.out.println("No titan has emerged.");

            if (!market.isEmpty()) {
                System.out.println("Remaining Company: " + market.peek());
            }
        }

        System.out.println("Total Mergers: " + mergerCount);
    }
}
