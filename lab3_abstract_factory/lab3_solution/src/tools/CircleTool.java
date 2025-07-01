package tools;

import core.Editor;
import core.Figure;
import figures.Circle;

import java.awt.*;

public class CircleTool extends AbstractCreationTool {

    public CircleTool(Editor editor) {
        super(editor);
    }

    @Override
    public Figure createFigure(Point start, Point end) {
        return new Circle(start, end);
    }
}
