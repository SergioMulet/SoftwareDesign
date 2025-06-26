package labs.lab5_command.original.editor.tools.figures;

import editor.core.*;
import labs.lab5_command.original.editor.figures.Rectangle;
import labs.lab5_command.original.editor.tools.AbstractCreationTool;

public class RectangleCreationTool extends AbstractCreationTool {
    
    public RectangleCreationTool(Editor editor) {
        super(editor);
    }

    @Override
    protected Figure createFigure(Area bounds) {
        return new Rectangle(bounds);
    }
}
