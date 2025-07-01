package figures;

import core.Figure;

import java.awt.*;

public class Rectangle implements Figure {

    private final Point start;
    private final Point end;


    public Rectangle(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw() {
        System.out.print("Rectangle from: " + start.x + ", " + start.y + " to " + end.x + ", " + end.y);
    }
}
