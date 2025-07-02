package game;

import graphics.Image2D;

import java.awt.*;

public interface Platform {

    Image2D loadImage(String file);

    Point getPosition();

    void drawBall(Image2D image, Point point);
}
