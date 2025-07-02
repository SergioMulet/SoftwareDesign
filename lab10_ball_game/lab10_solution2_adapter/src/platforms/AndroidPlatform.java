package platforms;

import android.AndroidAPI;
import game.Platform;
import graphics.Image2D;

import java.awt.*;

public class AndroidPlatform implements Platform {

    private AndroidAPI android = new AndroidAPI();

    @Override
    public Image2D loadImage(String file) {
        return android.loadResource(file);
    }

    @Override
    public Point getPosition() {
        return android.getTouch();
    }

    @Override
    public void drawBall(Image2D image, Point point) {
        android.draw(point.x, point.y, image);
    }
}
