package editor.core;

public interface Action {
    void undo();
    void execute();
}
