package actions;

import machine.Machine;

public class NumberOfTicketsAction implements Action<Integer>{

    private Machine machine;
    private int availableTickets;

    public NumberOfTicketsAction(Machine machine, int availableTickets) {
        this.machine = machine;
        this.availableTickets = availableTickets;
    }

    @Override
    public Integer execute() {
        return machine.howManyTickets(availableTickets);
    }
}
