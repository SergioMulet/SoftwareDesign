package game;

import android.AndroidAPI;
import graphics.Image2D;
import playstation.Playstation5API;
import windows.WindowsAPI;

import java.awt.*;

// This class, and all the code inside this package, is supposed to be the
// complete game code, and it is what we want to reuse in the different
// platforms.

enum Platform {
	ANDROID, WINDOWS, PLAYSTATION
};

public class BallGame {
	
	// This variable decides the platform being targeted
	private Platform platform = Platform.ANDROID;

	private AndroidAPI android;
	private WindowsAPI windows;
	private Playstation5API playstation;

	public void play() {
		
		setAPI();

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

	private void setAPI() {
		switch (platform) {
			case ANDROID -> android = new AndroidAPI();
			case WINDOWS -> windows = new WindowsAPI();
			case PLAYSTATION -> playstation = new Playstation5API();
		}
	}

	private Image2D loadImage(String file) {
		if (platform == Platform.ANDROID)
			return android.loadResource(file);
		else if (platform == Platform.WINDOWS)
			return windows.loadFile(file);
		else if (platform == Platform.PLAYSTATION)
			return playstation.loadGraphics(file);
		else
			throw new AssertionError("Platform not supported");
	}

	private Point getPosition() {
		if (platform == Platform.ANDROID)
			return android.getTouch();
		else if (platform == Platform.WINDOWS)
			return windows.getMouseClick();
		else if (platform == Platform.PLAYSTATION)
			return playstation.getJoystick();
		else
			throw new AssertionError("Platform not supported");
	}

	private void drawBall(Image2D image, Point point) {
		if (platform == Platform.ANDROID)
			android.draw(point.x, point.y, image);
		else if (platform == Platform.WINDOWS)
			windows.paint(point.x, point.y, image);
		else if (platform == Platform.PLAYSTATION)
			playstation.render(point.x, point.y, image);
		else
			throw new AssertionError("Platform not supported");
	}
}
