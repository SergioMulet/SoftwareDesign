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
        do {
            int numberOfTickets = machine.getKeyboard().readInt();
            if (numberOfTickets <= availableTickets)
                return numberOfTickets;
            machine.getDisplay().show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
                    availableTickets));
        } while (true);
    }
}
