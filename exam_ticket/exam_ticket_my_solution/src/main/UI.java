package main;

import actions.ChooseEventAction;
import actions.NumberOfTicketsAction;
import actions.SelectPaymentAction;
import machine.Executor;
import machine.Machine;
import machine.Payment;
import machine.model.Event;
import machine.model.Ticket;

import java.util.List;

public class UI {

    private Machine machine;
    private Executor executor;

    public UI(Machine machine){
        this.machine = machine;
    }

    public void run(){
        machine.loadPayments();
        while (true)
        {
            Event selectedEvent = executor.execute(new ChooseEventAction(machine));

            machine.getDisplay().show("\n¿Cuántas entradas desea comprar? ");
            int numberOfTickets = executor.execute(new NumberOfTicketsAction(machine, selectedEvent.getAvailableTickets()));

            // se calcula el importe a pagar
            double amountToPay = numberOfTickets * selectedEvent.getPrice();
            machine.getDisplay().show(String.format("Importe a pagar: %.2f €%n", amountToPay));

            Payment paymentMode = executor.execute(new SelectPaymentAction(machine));

            // se realiza el pago
            boolean isValidPayment = paymentMode.pay(machine, amountToPay);

            if (!isValidPayment) {
                machine.getDisplay().show("No se ha podido completar el pago\n\n");
                continue;
            }

            // se generan las entradas
            List<Ticket> tickets = selectedEvent.generateTickets(numberOfTickets);

            // por último, la máquina imprime las entradas generadas
            machine.getDisplay().show("\nSus entradas se están imprimiendo...\n");
            for (Ticket ticket : tickets) {
                machine.getPrinter().printTicket(ticket);
            }

            machine.getDisplay().show("Gracias por su compra, que disfrute del evento.\n\n");
        }
    }

    public void addEvent(Event event){
        machine.addEvent(event);
    }
}
