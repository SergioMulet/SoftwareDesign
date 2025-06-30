package core;

import tools.SelectionTool;

import java.util.HashMap;

public class Editor {

	private Drawing drawing;
	private Tool currentTool;
	private HashMap<String, Tool> tools = new HashMap<>();
	
	public Editor() {
		this(new Drawing());
		setDefaultTool();
	}

	private void setDefaultTool() {
		currentTool = new SelectionTool();
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
		currentTool = tools.get(toolName);
	}

	public void mousePressed(int x, int y) {
		currentTool.mousePressed(x, y);
	}

	public void mouseMoved(int x, int y) {
		currentTool.mouseMoved(x, y);
	}

	public void mouseReleased(int x, int y) {
		currentTool.mouseReleased(x, y);
	}
}
