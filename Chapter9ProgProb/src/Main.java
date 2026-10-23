public class Main {
    public static void main(String[] args) {
        InventoryComponent excalibur = new Item("Excalibur", 12.5);
        InventoryComponent healthPotion = new Item("Health Potion", 0.5);
        InventoryComponent gem = new Item("Ruby", 0.1);

        Bag beltPouch = new Bag("Belt Pouch", 0.5);
        beltPouch.add(healthPotion);
        beltPouch.add(gem);

        System.out.println("--- Testing Bag and Recursion ---");
        beltPouch.displayInfo();
        System.out.println("\nTotal weight of belt pouch: " + beltPouch.getWeight() + " lbs");
    }
}
