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

        System.out.println("Starting Company Market:");
        System.out.println(market);

        while (market.size() > 1) {

            Company companyA = market.poll();
            Company companyB = market.poll();

            int newSize = (int) ((companyA.getSize() + companyB.getSize()) * 1.1);

            String newName = companyA.getName() + "-" + companyB.getName();

            Company mergedCompany = new Company(newName, newSize);

            System.out.println("Merger: " + companyA.getName()
                    + " and " + companyB.getName()
                    + " have merged into " + mergedCompany.getName()
                    + " with size " + mergedCompany.getSize() + "!");

            market.add(mergedCompany);
        }

        System.out.println("Final Company:");
        System.out.println(market.poll());
    }
}
