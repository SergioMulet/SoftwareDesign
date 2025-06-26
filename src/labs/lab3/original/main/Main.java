package labs.lab3.original.main;

import java.io.*;

import editor.core.Editor;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Editor editor = new Editor();
		
		run(editor);
	}

	// Simulates the interaction of the user with the editor. Note that it does
	// not represent the user interface itself (not even a text-based one), but
	// the system events that would be triggered by the graphical library when
	// the user interacts with the editor. Therefore, it is not part of the
	// editor's logic, and should remain in the main class as is.
	//
	private static void run(Editor editor) throws IOException {

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
			String action = tokens[0];

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

			// Checks that the rest of the actions do not have arguments
			if (tokens.length > 1) {
				output.printf("Syntax error: %s has no arguments\n", action);
				continue;
			}

			if (action.equals("selection")) {
				editor.toolButtonPressed("selection");
			} else if (action.equals("rectangle")) {
				editor.toolButtonPressed("rectangle");
			} else if (action.equals("circle")) {
				editor.toolButtonPressed("circle");
			} else if (action.equals("triangle")) {
				editor.toolButtonPressed("triangle");
			} else if (action.equals("draw")) {
				editor.draw();
			} else if (action.equals("help")) {
				showHelp(output);
			} else {
				output.println("Unknown action");
				showHelp(output);
			}
		} while (true);
	}

	private static void showHelp(PrintStream output) {
		output.println("");
		output.println("Tools: selection - rectangle - circle - triangle");
		output.println("Mouse actions: click <x>,<y> - move <x>,<y> - release <x>,<y>");
		output.println("Other options: draw - help - exit");
		output.println("-------------------------------------------------------------");
	}

	// Receives a string with the coordinates of a point in the form "x, y" 
	// and returns a point. The coordinates can be separated by any number
	// of spacesbefore and after the comma.
	//
	private static Point parseCoordinates(String coordinates) {
		String[] arguments = coordinates.split("\\s*,\\s*");
		int x = Integer.parseInt(arguments[0]);
		int y = Integer.parseInt(arguments[1]);
		return new Point(x, y);
	}

	private record Point(int x, int y) {}
}
