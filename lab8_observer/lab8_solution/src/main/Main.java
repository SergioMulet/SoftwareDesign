package main;

import poll.Poll;
import poll.PollObserver;
import poll.TextUserInterface;
import poll.observers.*;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Poll poll = new Poll("Are you in favor of nuclear energy?");
		TextUserInterface ui = new TextUserInterface();

		//Observers
		PollObserver pieChart = new PieChartObserver();
		PollObserver barChart = new BarChartObserver();
		PollObserver save = new SaveObserver();
		PollObserver statusBar = new StatusBarObserver();
		PollObserver barChartSkip = new SkipObserver(barChart, 3);

		// EXERCISE 1
		poll.addObserver(pieChart);
		poll.addObserver(barChart);
		poll.addObserver(save);
		//ui.fill(poll);

		// PROGRAM 1
		poll.addObserver(statusBar);
		//ui.fill(poll);

		//Program 2
		poll.removeObserver(barChart);
		//ui.fill(poll);

		//Program 3
		poll.addObserver(barChartSkip);
		ui.fill(poll);

		//Next porgrams are more or less the same, getting the 3 is the most difficult. 4 is the same but
		// instead of skip, repeat (every 2 votes observe) and 5 is a mix of both
	}
}