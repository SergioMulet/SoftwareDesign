package machine;

import actions.Action;

public class Executor {

    public <T> T execute(Action<T> action) {
        return action.execute();
    }
}
