import java.util.HashMap;
import java.util.Scanner;

public class FieldRegistry {
    public static void main(String[] args) {

        HashMap<String, Integer> speciesRegistry = new HashMap<>();

        speciesRegistry.put("Elephant", 500);
        speciesRegistry.put("Tiger", 320);
        speciesRegistry.put("Lion", 450);
        speciesRegistry.put("Giraffe", 275);
        speciesRegistry.put("Zebra", 600);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a species name to check its population: ");
        String species = scanner.nextLine();

        Integer population = speciesRegistry.get(species);


        if (population != null) {
            System.out.println(species + " currently has a population of "
                    + population + ".");
        } else {
            System.out.println("Sorry, " + species
                    + " is not currently in the registry.");
        }

        scanner.close();
    }
}
