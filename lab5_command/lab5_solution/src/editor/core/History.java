package editor.core;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {

    Deque<Action> undoableActions = new ArrayDeque<>();
    Deque<Action> redoableActions = new ArrayDeque<>();

    public void execute(Action action) {
        action.execute();
        add(action);
    }

    public void add(Action action) {
        undoableActions.push(action);
        redoableActions.clear();
    }

    public boolean canUndo(){
        return !undoableActions.isEmpty();
    }

    public boolean canRedo(){
        return !redoableActions.isEmpty();
    }

    public void undo() {
        if(canUndo()){
            Action action = undoableActions.pop();
            action.undo();
            redoableActions.push(action);
        }
    }

    public void redo(){
        if(canRedo()){
            Action action = redoableActions.pop();
            action.execute();
            undoableActions.push(action);
        }
    }
}
