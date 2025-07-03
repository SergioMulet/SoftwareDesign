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
        machine.showEvents();
        int option = machine.getKeyboard().readOption(machine.getEvents().size());
        Event event = machine.getEvents().get(option - 1);
        machine.showEvent(event);
        return event;
    }
}
