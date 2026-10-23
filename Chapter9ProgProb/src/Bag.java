import java.util.ArrayList;
import java.util.List;

class Bag extends InventoryComponent {
    private final String name;
    private final double baseWeight;
    private final List<InventoryComponent> components = new ArrayList<>();

    public Bag(String name, double baseWeight) {
        this.name = name;
        this.baseWeight = baseWeight;
    }

    @Override
    public void add(InventoryComponent component) {
        components.add(component);
    }

    @Override
    public void remove(InventoryComponent component) {
        components.remove(component);
    }

    @Override
    public InventoryComponent getChild(int i) {
        return components.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        double totalWeight = baseWeight;
        for (InventoryComponent component : components) {
            totalWeight += component.getWeight();
        }
        return totalWeight;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bag: " + name + " | Base Weight: " + baseWeight + " lbs | Total Weight: " + getWeight() + " lbs");
        for (InventoryComponent component : components) {
            System.out.print("  - ");
            component.displayInfo();
        }
    }
}
