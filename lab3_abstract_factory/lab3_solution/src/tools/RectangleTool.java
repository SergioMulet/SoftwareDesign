package tools;

import core.Editor;
import core.Figure;
import figures.Rectangle;

import java.awt.*;


public class RectangleTool extends AbstractCreationTool {

    public RectangleTool(Editor editor) {
        super(editor);
    }

    @Override
    public Figure createFigure(Point start, Point end) {
        return new Rectangle(start, end);
    }
}
