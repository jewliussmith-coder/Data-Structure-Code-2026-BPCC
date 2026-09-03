public class EditorHistory {
    private Stack<String> undoStack;
    private String currentState;

    public EditorHistory() {
        undoStack = new Stack<>();
        currentState = "";
    }

    public void makeChange(String newState) {
        // Save the current state before replacing it
        undoStack.push(currentState);

        // Replace current state
        currentState = newState;
    }

    public void undo() {
        // undo if there is a previous state
        if (!undoStack.isEmpty()) {
            currentState = undoStack.pop();
        }
    }

    public String getCurrentState() {
        return currentState;
    }
}
