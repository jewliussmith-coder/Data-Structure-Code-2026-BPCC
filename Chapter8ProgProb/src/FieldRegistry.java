import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FieldRegistry {

    public static void main(String[] args) throws FileNotFoundException {


        HashMap<String, Integer> speciesRegistry = new HashMap<>();

        speciesRegistry.put("Elephant", 500);
        speciesRegistry.put("Tiger", 320);
        speciesRegistry.put("Lion", 450);
        speciesRegistry.put("Giraffe", 275);
        speciesRegistry.put("Zebra", 600);


        Scanner fileScanner = new Scanner(new File("sightings.txt"));

        while (fileScanner.hasNextLine()) {

            String species = fileScanner.nextLine().trim();


            if (species.isEmpty()) {
                continue;
            }


            if (speciesRegistry.containsKey(species)) {


                speciesRegistry.put(
                        species,
                        speciesRegistry.get(species) + 1
                );

            } else {


                speciesRegistry.put(species, 1);
            }
        }

        fileScanner.close();

        System.out.println("=== FIELD REGISTRY ====");
        System.out.println("Updated Species Populations:");

        for (String species : speciesRegistry.keySet()) {
            System.out.println(
                    species + ": " + speciesRegistry.get(species)
            );
        }

        System.out.println("=========");
    }
}

