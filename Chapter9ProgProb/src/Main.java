public class Main {
    public static void main(String[] args) {
        // Create at least two distinct Item instances
        InventoryComponent excalibur = new Item("Excalibur", 12.5);
        InventoryComponent healthPotion = new Item("Health Potion", 0.5);

        System.out.println("--- Testing Leaf Items ---");

        // Call displayInfo() on each item
        excalibur.displayInfo();
        healthPotion.displayInfo();

        // Print weights individually to verify getWeight()
        System.out.println("\n--- Explicit Weight Queries ---");
        System.out.println(excalibur.getName() + " weight: " + excalibur.getWeight() + " lbs");
        System.out.println(healthPotion.getName() + " weight: " + healthPotion.getWeight() + " lbs");
    }
}