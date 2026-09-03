public class EditorHistory {
    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private String currentState;

    public EditorHistory() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
        currentState = "";
    }

    public void makeChange(String newState) {
        // Save the current state before replacing it
        undoStack.push(currentState);

        // A new change clears the redo history
        redoStack = new Stack<>();

        // Replace the current state
        currentState = newState;
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            // Save current state so it can be redone
            redoStack.push(currentState);

            // Restore previous state
            currentState = undoStack.pop();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            // Save current state so it can be undone again
            undoStack.push(currentState);

            // Restore the undone state
            currentState = redoStack.pop();
        }
    }

    public String getCurrentState() {
        return currentState;
    }
}
