package editor.actions;

import editor.core.Action;
import editor.core.Figure;

public class MoveAction implements Action {

    private int dx;
    private int dy;
    Figure figure;

    public MoveAction(int dx, int dy, Figure figure) {
        this.dx = dx;
        this.dy = dy;
        this.figure = figure;
    }

    @Override
    public void undo() {
        figure.moveBy(-dx, -dy);
    }

    @Override
    public void execute() {
        figure.moveBy(dx, dy);
    }
}
