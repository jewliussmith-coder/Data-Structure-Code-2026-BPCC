public class Main {
    public static void main(String[] args) {

        EditorHistory editor = new EditorHistory();

        // Type three words
        editor.makeChange("one");
        editor.makeChange("one two");
        editor.makeChange("one two three");

        System.out.println("Current: " + editor.getCurrentState());

        // Undo twice
        editor.undo();
        System.out.println("After first undo: " + editor.getCurrentState());

        editor.undo();
        System.out.println("After second undo: " + editor.getCurrentState());

        // Redo once
        editor.redo();
        System.out.println("After redo: " + editor.getCurrentState());

        // Type a new word
        editor.makeChange("one two four");
        System.out.println("After new change: " + editor.getCurrentState());

        // Attempt to redo
        editor.redo();
        System.out.println("After attempting redo: " + editor.getCurrentState());
    }
}
