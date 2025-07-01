package tools;

import core.Editor;
import core.Tool;
import figures.Triangle;

import java.awt.*;

public class TriangleTool implements Tool {

    private Point [] vertices = new Point[3];
    private int numberOfVertices = 0;
    private Editor editor;

    public TriangleTool(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void mousePressed(int x, int y) {
        vertices[numberOfVertices] = new Point(x, y);
        numberOfVertices++;
        if(numberOfVertices >= 3){
            editor.addFigure(new Triangle(vertices[0], vertices[1], vertices[2]));
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        // DO NOTHING
    }

    @Override
    public void mouseReleased(int x, int y) {
        // DO NOTHING
    }
}
