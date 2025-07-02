package poll.observers;

import poll.Poll;
import poll.PollObserver;

public class SkipObserver implements PollObserver {

    private final PollObserver observer;
    private final int skip;

    public SkipObserver(PollObserver observer, int skip) {
        this.observer = observer;
        this.skip = skip;
    }

    @Override
    public void observe(Poll poll) {
        if(poll.yeses() + poll.nos() >= skip){
            observer.observe(poll);
        }
    }
}
