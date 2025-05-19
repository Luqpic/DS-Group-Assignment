package groupassignment2;

import java.util.Stack;

public class UndoRedoManager {
    private Stack<String> und;
    private Stack<String> redo;

    public UndoRedoManager() {
        undo = new Stack<>();
        redo = new Stack<>();
    }

    public void perform(String action) {
        // Add action to undo stack
        undo.push(action);
        // Clear redo stack since a new action was performed
        redo.clear();
    }

    public String undo() {
        if (undo.isEmpty()) {
            return "Nothing to undo";
        }

        // Pop the last action from undo stack
        String lastAction = undo.pop();

        // Add to redo stack
        redo.push(lastAction);

        return lastAction;
    }

    public String redo() {
        if (redo.isEmpty()) {
            return "Nothing to redo";
        }

        // Pop the last action from redo stack
        String lastAction = redo.pop();

        // Add back to undo stack
        undo.push(lastAction);

        return lastAction;
    }

    public void printStacks() {
        System.out.println("Undo Stack: " + undo);
        System.out.println("Redo Stack: " + redo);
    }

    // Example usage
    public static void main(String[] args) {
        UndoRedoManager manager = new UndoRedoManager();

        // Perform some actions
        manager.perform("add:Hi");
        manager.perform("add:How are you?");
        manager.perform("remove:Bye");

        // Print the current state of stacks
        System.out.println("Initial state:");
        manager.printStacks();

        // Test undo
        System.out.println("\nUndo: " + manager.undo());
        manager.printStacks();

        // Test redo
        System.out.println("\nRedo: " + manager.redo());
        manager.printStacks();

        // Multiple undo operations
        System.out.println("\nUndo twice:");
        System.out.println("Undo: " + manager.undo());
        System.out.println("Undo: " + manager.undo());
        manager.printStacks();

        // Perform a new action after undo
        manager.perform("add:New message after undo");
        System.out.println("\nAfter new action:");
        manager.printStacks();
    }
}
