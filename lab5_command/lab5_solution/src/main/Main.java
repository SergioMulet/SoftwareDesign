package main;

import editor.core.Editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class Main {

	private static Editor editor;

	public static void main(String[] args) throws IOException {
		
		editor = new Editor();
		run();
	}

	// Simulates the interaction of the user with the editor. Note that it does
	// not represent the user interface itself (not even a text-based one), but
	// the system events that would be triggered by the graphical library when
	// the user interacts with the editor. Therefore, it is not part of the
	// editor's logic, and should remain in the main class as is.
	//
	private static void run() throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream output = System.out;

		showHelp(output);
		do {
			output.print("> ");
			output.flush();

			// Asks the user via console and splits the entered line into two 
			// parts: first, the name of the tool button that has been pressed,
			// the mouse action, or any other option; after that, the rest of
			// the line. For example:
			//
			// > click 100, 100 ---> tokens = [ "click", "100, 100" ]
			//
			String[] tokens = input.readLine().split(" ", 2);
			String action = tokens[0].trim();

			if (action.equals("exit")) {
				output.println("Bye!");
				return;
			}

			//$ Mouse actions -----------------------------------

			if (action.equals("click") || action.equals("move") || action.equals("release")) {	
				try {					
					
					Point point = parseCoordinates(tokens[1]);
					
					if (action.equals("click")) {
						editor.mousePressed(point.x, point.y);
					} else if (action.equals("move")) {
						editor.mouseMoved(point.x, point.y);
					} else {
						editor.mouseReleased(point.x, point.y);
					}
				
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					output.println("Syntax error: expected coordinates of the point: <x>, <y>");
				}
				continue; 
			}

			if (editor.toolNames().contains(action)) {
				editor.toolButtonPressed(action);
			} else if (action.equals("draw")) {
				editor.draw();
			} else if (action.equals("help")) {
				showHelp(output);
			} else if (action.equals("undo")){
				if(editor.canUndo()){
					editor.undo();
				}
				else{
					System.out.println("Nothing to undo");
				}
			} else if (action.equals("redo")){
				if(editor.canRedo()){
					editor.redo();
				}
				else{
					System.out.println("Nothing to redo");
				}
			} else {
				output.println("Unknown action");
				showHelp(output);
			}
		} while (true);
	}

	private static void showHelp(PrintStream output) {
		output.println("");
		output.println("Tools: " + showTools());
		output.println("Mouse actions: click <x>, <y> - move <x>, <y> - release <x>, <y>");
		output.println("Other options: draw - help - exit");
		output.println("----------------------------------------------------------------");
	}

	private static String showTools() {
		List<String> toolNames = editor.toolNames();
		return String.join(" - ", toolNames);
	}

	// Receives a string with the coordinates of a point in the form "x, y" 
	// and returns a point. The coordinates can be separated by any number
	// of spaces before and after the comma.
	//
	private static Point parseCoordinates(String coordinates) {
		String[] arguments = coordinates.split("\\s*,\\s*");
		int x = Integer.parseInt(arguments[0]);
		int y = Integer.parseInt(arguments[1]);
		return new Point(x, y);
	}

	private record Point(int x, int y) {}
}
