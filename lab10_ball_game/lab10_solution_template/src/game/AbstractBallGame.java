package game;

import graphics.Image2D;

import java.awt.*;

public abstract class AbstractBallGame {

    public void play() {
        Image2D image = loadImage("ball.png");

        // This simulates the game loop
        for (int i = 0; i < 10; i++) {
            Point point = getPosition();
            // Check collision with walls
            // Update score
            // Other game logic
            // ...
            drawBall(image, point);
        }
    }

    public abstract Point getPosition();

    public abstract void drawBall(Image2D image, Point point);

    public abstract Image2D loadImage(String path);
}
