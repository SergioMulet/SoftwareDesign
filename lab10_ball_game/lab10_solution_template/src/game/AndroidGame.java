package game;

import android.AndroidAPI;
import graphics.Image2D;

import java.awt.*;

public class AndroidGame extends AbstractBallGame{

    private final AndroidAPI android = new AndroidAPI();

    @Override
    public Point getPosition(){
        return android.getTouch();
    }

    @Override
    public void drawBall(Image2D image, Point point) {
        android.draw(point.x, point.y, image);
    }

    @Override
    public Image2D loadImage(String file) {
        return android.loadResource(file);
    }
}
