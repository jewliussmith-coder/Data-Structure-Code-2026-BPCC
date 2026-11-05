public class Company implements Comparable<Company> {
    private String name;
    private int size;

    public Company(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Company other) {
        return Integer.compare(this.size, other.size);
    }

    @Override
    public String toString() {
        return name + " - Size: " + size;
    }
}
