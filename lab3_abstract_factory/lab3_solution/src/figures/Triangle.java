package figures;

import core.Figure;

import java.awt.*;

public class Triangle implements Figure {

    private final Point v1;
    private final Point v2;
    private final Point v3;

    public Triangle(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public void draw() {
        System.out.println("Triangle: " + "v1 at " + v1 + " v2 at " + v2 + " v3 at " + v3);
    }
}
