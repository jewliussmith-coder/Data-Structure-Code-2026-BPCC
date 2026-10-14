public class Main {
    public static void main(String[] args) {
        SinglyLinkedList playlist = new SinglyLinkedList();

        playlist.addLast(new Song("September", "Earth, Wind & Fire", 215));
        playlist.addLast(new Song("I'm Still Standing", "Elton John", 183));
        playlist.addLast(new Song("Let's Groove", "Earth, Wind & Fire", 236));

        playlist.display();
    }
}
