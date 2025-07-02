package editor.actions;

import editor.core.Action;
import editor.core.Drawing;
import editor.core.Figure;

public class CreateAction implements Action {

    Figure figure;
    Drawing drawing;

    public CreateAction(Figure figure, Drawing drawing) {
        this.figure = figure;
        this.drawing = drawing;
    }

    @Override
    public void undo() {
        drawing.removeFigure(figure);
    }

    @Override
    public void execute() {
        drawing.addFigure(figure);
    }
}
