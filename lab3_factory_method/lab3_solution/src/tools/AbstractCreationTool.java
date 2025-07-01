package tools;

import core.Editor;
import core.Figure;
import core.Tool;

import java.awt.*;

public abstract class AbstractCreationTool implements Tool {

    Editor editor;
    private Point start;
    private Point end;

    public AbstractCreationTool(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void mousePressed(int x, int y) {
        start = new Point(x, y);
    }

    @Override
    public void mouseMoved(int x, int y) {
        start.translate(x, y);
        end.translate(x, y);
    }

    @Override
    public void mouseReleased(int x, int y) {
        end = new Point(x, y);
        editor.addFigure(createFigure(start, end));
    }

    public abstract Figure createFigure(Point start, Point end);
}
