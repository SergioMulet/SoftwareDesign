package labs.lab8_observer.original.poll;

public class Poll 
{
	private int yeses;
	private int nos;
	private String question;
	
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
		updatePieChart();
		updateBarChart();
		saveResults();
	}

	public void incrementNos() {
		nos++;
		updatePieChart();
		updateBarChart();
		saveResults();
	}

	private void updateBarChart() {
		System.out.println("Drawing a bar chart...");
	}

	private void updatePieChart() {
		System.out.println("Drawing a pie chart...");
	}

	private void saveResults() {
		System.out.println("Saving the results in a database...");
	}
}
