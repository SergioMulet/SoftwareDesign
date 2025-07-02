package game;

import graphics.Image2D;
import windows.WindowsAPI;

import java.awt.*;

public class WindowsGame extends AbstractBallGame{

    private final WindowsAPI windows = new WindowsAPI();

    @Override
    public Point getPosition() {
        return windows.getMouseClick();
    }

    @Override
    public void drawBall(Image2D image, Point point) {
        windows.paint(point.x, point.y, image);
    }

    @Override
    public Image2D loadImage(String file) {
        return windows.loadFile(file);
    }
}
