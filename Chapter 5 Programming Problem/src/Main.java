import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Artifact> museumList = new ArrayList<>();

        museumList.add(new Artifact("M04", "Ancient Coin", "Ancient Rome"));
        museumList.add(new Artifact("A01", "Stone Tool", "Stone Age"));
        museumList.add(new Artifact("Z99", "Modern Sculpture", "Modern"));
        museumList.add(new Artifact("B12", "Medieval Shield", "Middle Ages"));

        System.out.println("Before sorting:");
        for (Artifact artifact : museumList)
            System.out.println(artifact);

        Collections.sort(museumList);

        System.out.println("\nAfter sorting:");
        for (Artifact artifact : museumList)
            System.out.println(artifact);
    }
}
