package editor.core;

import editor.tools.SelectionTool;
import editor.tools.figures.CircleCreationTool;
import editor.tools.figures.RectangleCreationTool;
import editor.tools.figures.TriangleCreationTool;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Editor {

	private Drawing drawing;
	private PrintWriter output; // Simulates the GUI widget for the drawing

	private Tool currentTool;
	private Tool defaultTool;
	
	private Map<String, Tool> toolbar = new LinkedHashMap<>();
	// The names of the tools to be shown in the status bar
	private Map<Tool, String> toolNames = new LinkedHashMap<>();

	private History history = new History();
	
	public Editor() {
		this(new Drawing());
	}
	
	public Editor(Drawing drawing) {
		output = new PrintWriter(System.out, true);
		setDrawing(drawing);
		currentTool = defaultTool = createDefaultTool();
		createTools();
	}

	public void draw() {
		drawing.draw(output);
		// Shows the name of the current tool in the status bar
		output.print("Current tool: " + toolNames.get(currentTool));
		output.println();
	}

	//$ Tool methods ---------------------------------------

	// Creates the default tool and adds it to the toolbar. If a subclass
	// overrides this method to create a different default tool, it must
	// also call 'addTool' to add the created tool with a name to the toolbar.
	//
	protected Tool createDefaultTool() {
		Tool tool = new SelectionTool(this);
		addTool("selection", tool);
		return tool;
	}

	// Creates the tools of the editor, except the default one, and adds them
	// 
	// to the toolbar, calling 'addTool'. Subclasses can override this method
	// to create their own tools.
	// 
	protected void createTools() {
		addTool("rectangle", new RectangleCreationTool(this));
		addTool("circle", new CircleCreationTool(this));
		addTool("triangle", new TriangleCreationTool(this));
	}

	protected void addTool(String name, Tool tool) {
		toolbar.put(name, tool);
		toolNames.put(tool, name);
	}

	public List<String> toolNames() {
		return new ArrayList<>(toolbar.keySet());
	}

	public Tool currentTool() {
		return currentTool;
	}

	public Tool defaultTool() {
		return defaultTool;
	}

	public void toolDone() {
		selectTool(defaultTool);
	}

	private void selectTool(Tool tool) {
		currentTool.reset();
		currentTool = tool;
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
		Tool tool = toolbar.get(toolName);
		if (tool == null)
			throw new IllegalArgumentException("Unknown tool: " + toolName);
		selectTool(tool);
	}

	public void mousePressed(int x, int y) {
		currentTool.clickedOn(x, y);
	}

	public void mouseMoved(int x, int y) {
		currentTool.movedTo(x, y);
	}

	public void mouseReleased(int x, int y) {
		currentTool.releasedOn(x, y);
	}

	public History getHistory() {
		return history;
	}

	public boolean canUndo(){
		return history.canUndo();
	}

	public boolean canRedo(){
		return history.canRedo();
	}

	public void undo(){
		history.undo();
	}

	public void redo(){
		history.redo();
	}
}
