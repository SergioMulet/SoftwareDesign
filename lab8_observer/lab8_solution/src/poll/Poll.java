package poll;

import java.util.ArrayList;
import java.util.List;

public class Poll
{
	private int yeses;
	private int nos;
	private final String question;
	private final List<PollObserver> observers = new ArrayList<>();
	
	public Poll(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public int yeses() {
		return yeses;
	}

	public int nos() {
		return nos;
	}

	public void incrementYeses() {
		yeses++;
		callObservers();
	}

	public void incrementNos() {
		nos++;
		callObservers();
	}

	public void addObserver(PollObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(PollObserver observer) {
		observers.remove(observer);
	}

	private void callObservers() {
		for(PollObserver observer : observers){
			observer.observe(this);
		}
	}
}
