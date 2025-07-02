package platforms;


import game.Platform;
import graphics.Image2D;
import playstation.Playstation5API;

import java.awt.*;

public class Playstation5Platform implements Platform {

    private final Playstation5API playstation = new Playstation5API();

    @Override
    public Image2D loadImage(String file) {
        return playstation.loadGraphics(file);
    }

    @Override
    public Point getPosition() {
        return playstation.getJoystick();
    }

    @Override
    public void drawBall(Image2D image, Point point) {
        playstation.render(point.x, point.y, image);
    }
}
