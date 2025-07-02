package windows;

import graphics.Image2D;

import java.awt.*;

public class WindowsAPI {

	private Point point = new Point(0, 0);

	public Image2D loadFile(String name) {
		System.out.println("(Windows) Image '" + name + "' loaded from disk.");
		return new Image2D(name, 10, 10);
	}

	public void paint(int x, int y, Image2D image) {
		System.out.println("(Windows) Drawing '" + image.getName() + "' at (" + x + ", " + y + ")");
	}

	// Returns the position where the user has clicked the mouse button.
	public Point getMouseClick() {
		point.translate(10, 10);
		return new Point(point);
	}
}
