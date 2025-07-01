package figures;

import core.Figure;

import java.awt.*;

public class Circle implements Figure {

    private final Point start;
    private final Point end;

    public Circle(Point start, Point end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw() {
        System.out.print("Circle from: " + start.x + ", " + start.y + " to " + end.x + ", " + end.y);
    }
}
