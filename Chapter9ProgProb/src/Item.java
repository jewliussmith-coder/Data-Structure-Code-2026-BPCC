public class Item extends InventoryComponent {
    private final String name;
    private final double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void displayInfo() {
        System.out.println("Item: " + getName() + " | Weight: " + getWeight() + " lbs");
    }
}