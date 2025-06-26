package labs.lab5_command.original.editor.tools.figures;

import editor.core.*;
import labs.lab5_command.original.editor.figures.Circle;
import labs.lab5_command.original.editor.tools.AbstractCreationTool;

public class CircleCreationTool extends AbstractCreationTool {
    
    public CircleCreationTool(Editor editor) {
        super(editor);
    }

    @Override
    protected Figure createFigure(Area bounds) {
        return new Circle(bounds);
    }
}
