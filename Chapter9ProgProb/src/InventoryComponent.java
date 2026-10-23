public abstract class InventoryComponent {

    public void add(InventoryComponent component) {
        throw new UnsupportedOperationException("Cannot add component to " + getClass().getSimpleName());
    }

    public void remove(InventoryComponent component) {
        throw new UnsupportedOperationException("Cannot remove component from " + getClass().getSimpleName());
    }

    public InventoryComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from " + getClass().getSimpleName());
    }

    public String getName() {
        throw new UnsupportedOperationException("getName() is not supported");
    }

    public double getWeight() {
        throw new UnsupportedOperationException("getWeight() is not supported");
    }

    public void displayInfo() {
        throw new UnsupportedOperationException("displayInfo() is not supported");
    }
}