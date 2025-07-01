package main;

import poll.Poll;
import poll.TextUserInterface;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("Are you in favor of nuclear energy?");

		TextUserInterface ui = new TextUserInterface();
		ui.fill(poll);
	}
}