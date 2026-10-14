public class Main {
    public static void main(String[] args) {
        SinglyLinkedList playlist = new SinglyLinkedList();

        playlist.addLast(new Song("September", "Earth, Wind & Fire", 215));
        playlist.addLast(new Song("I'm Still Standing", "Elton John", 183));
        playlist.addLast(new Song("Let's Groove", "Earth, Wind & Fire", 236));

        System.out.println("--- Initial Playlist ---");
        playlist.display();

        System.out.println("\n--- Testing get(1) ---");
        System.out.println("Song at index 1: " + playlist.get(1));

        System.out.println("\n--- Inserting 'Smooth Criminal' at index 1 ---");
        playlist.add(1, new Song("Smooth Criminal", "Michael Jackson", 258));

        System.out.println("\n--- Playlist After Positional Insertion ---");
        playlist.display();
    }
}
