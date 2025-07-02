package editor.tools;

import editor.core.*;

public class SelectionTool implements Tool {

    private Editor editor;
    private Figure figure;
    private Point lastPosition;

    public SelectionTool(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void reset() {
        figure = null;
        lastPosition = null;
    }

    @Override
    public void clickedOn(int x, int y) {
        figure = editor.drawing().findFigureAt(x, y);
        if (figure != null)
            lastPosition = new Point(x, y);
    }

    @Override
    public void movedTo(int x, int y) {
        move(x, y);
    }

    @Override
    public void releasedOn(int x, int y) {
        move(x, y);        
        reset();
    }

    private void move(int x, int y) {
        if (!isDragging())
            return;
        figure.moveBy(x - lastPosition.x(), y - lastPosition.y());
        lastPosition = new Point(x, y);
    }

    private boolean isDragging() {
        return figure != null;
    }
}
