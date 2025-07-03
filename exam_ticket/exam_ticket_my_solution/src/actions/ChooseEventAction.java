package actions;

import machine.Machine;
import machine.model.Event;

public class ChooseEventAction implements Action<Event> {

    private final Machine machine;

    public ChooseEventAction(Machine machine) {
        this.machine = machine;
    }

    @Override
    public Event execute() {
        return machine.selectEvent();
    }
}
