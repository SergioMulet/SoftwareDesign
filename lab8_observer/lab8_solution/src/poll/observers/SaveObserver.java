package poll.observers;

import poll.Poll;
import poll.PollObserver;

public class SaveObserver implements PollObserver {
    @Override
    public void observe(Poll poll) {
        System.out.println("Saving the results in a database...");
    }
}
