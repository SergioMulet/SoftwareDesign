package core;

public class Editor {

	private Drawing drawing;
	
	public Editor() {
		this(new Drawing());
	}
	
	public Editor(Drawing drawing) {
		setDrawing(drawing);
	}

	public void draw() {
		// In a real application, this method would draw not only the
		// drawing, but also the menu, the toolbar, the status bar...
		drawing.draw();
	}
	
	//$ Drawing methods -----------------------------------
	
	public Drawing drawing() {
		return drawing;
	}
		
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}
		
    //$ UI methods ----------------------------------------

	public void toolButtonPressed(String toolName) {
		// ...
	}

	public void mousePressed(int x, int y) {
		// ...
	}

	public void mouseMoved(int x, int y) {
		// ...
	}

	public void mouseReleased(int x, int y) {
		// ...
	}
}
