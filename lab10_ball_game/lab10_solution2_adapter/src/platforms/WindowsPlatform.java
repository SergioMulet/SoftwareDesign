package platforms;

import game.Platform;
import graphics.Image2D;
import windows.WindowsAPI;

import java.awt.*;

public class WindowsPlatform implements Platform {

    private final WindowsAPI windows = new WindowsAPI();

    @Override
    public Image2D loadImage(String file) {
        return windows.loadFile(file);
    }

    @Override
    public Point getPosition() {
        return windows.getMouseClick();
    }

    @Override
    public void drawBall(Image2D image, Point point) {
        windows.paint(point.x, point.y, image);
    }
}
