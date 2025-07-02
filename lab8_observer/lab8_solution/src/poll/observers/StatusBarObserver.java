package poll.observers;

import poll.Poll;
import poll.PollObserver;

public class StatusBarObserver implements PollObserver {
    @Override
    public void observe(Poll poll) {
        int yes = poll.yeses();
        int nos = poll.nos();
        System.out.println("Number of YES votes = " + yes + ". Number of NOS votes = " + nos);
    }
}
