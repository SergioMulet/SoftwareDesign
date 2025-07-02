package poll.observers;

import poll.Poll;
import poll.PollObserver;

public class BarChartObserver implements PollObserver {

    @Override
    public void observe(Poll poll) {
        System.out.println("Drawing a bar chart...");
    }
}
