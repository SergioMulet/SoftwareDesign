package labs.lab8_observer.original.main;
import java.io.*;

import poll.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("Are you in favor of nuclear energy?");

		TextUserInterface ui = new TextUserInterface();
		ui.fill(poll);
	}
}