import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // 1. Sorted by Title
        SortedLinkedList titlePlaylist = new SortedLinkedList(Comparator.comparing(Song::getTitle));
        titlePlaylist.add(new Song("September", "Earth, Wind & Fire", 215));
        titlePlaylist.add(new Song("Smooth Criminal", "Michael Jackson", 258));
        titlePlaylist.add(new Song("I'm Still Standing", "Elton John", 183));

        System.out.println("--- Sorted by Title ---");
        titlePlaylist.display();

        // 2. Sorted by Artist
        SortedLinkedList artistPlaylist = new SortedLinkedList(Comparator.comparing(Song::getArtist));
        artistPlaylist.add(new Song("September", "Earth, Wind & Fire", 215));
        titlePlaylist.add(new Song("Smooth Criminal", "Michael Jackson", 258));
        artistPlaylist.add(new Song("I'm Still Standing", "Elton John", 183));

        System.out.println("\n--- Sorted by Artist ---");
        artistPlaylist.display();
    }
}
