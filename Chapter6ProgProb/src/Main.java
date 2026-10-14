import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList playlist = new SinglyLinkedList();

        playlist.addLast(new Song("September", "Earth, Wind & Fire", 215));
        playlist.addLast(new Song("I'm Still Standing", "Elton John", 183));
        playlist.addLast(new Song("Let's Groove", "Earth, Wind & Fire", 236));

        System.out.println("- Initial Playlist -");
        playlist.display();

        System.out.println("\n-Iterating using For-Each Loop-");
        for (Song song : playlist) {
            System.out.println(song);
        }

        System.out.println("\n- Removing 2nd song using Iterator -");
        Iterator<Song> iterator = playlist.iterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.toString().contains("I'm Still Standing")) {
                iterator.remove();
            }
        }

        System.out.println("\n-Playlist After Removal-");
        playlist.display();
    }
}
