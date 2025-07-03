package machine;

import java.util.*;

import actions.ChooseEventAction;
import actions.NumberOfTicketsAction;
import actions.SelectPaymentAction;
import machine.hardware.*;
import machine.model.*;
import machine.payment.CardPayment;
import machine.payment.CashPayment;
import ruralvia.BankGateway;

/**
 * This solution have been developed by myself, I have no official solution for this exam
 * I have mainly applied strategy for Payments and Command for actions like choosing the
 * event, number of tickets the user wants to buy and the payment mode.
 * If you want to allow undo operations do it in executor class using a deque
 *
 * The original code corresponds to the teachers of the subject.
 */


public class Machine 
{
	
	private List<Event> events = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();
	
	// pasarela de pagos (para los pagos con tarjeta)
	private BankGateway bankGateway = new BankGateway();

	private Map<String, Payment> payments = new HashMap();

	private Executor executor = new Executor();
	
	
	
	//-- Métodos públicos
	//-------------------------------------------------------------------------

	public void addEvent(Event event)
	{
		events.add(event);
	}


	//-- Pago
	//-------------------------------------------------------------------------

	public void loadPayments(){
		payments.put("1", new CardPayment());
		payments.put("2", new CashPayment());
	}

	public void showPaymentModes(){
		display.show("\nEscoja un método de pago:\n");
		payments.forEach( (key, value) -> {display.show("  "+key+". "+value.getName()+"\n");});
	}

	public Payment selectPaymentMode()
	{
		showPaymentModes();
		int option = keyboard.readOption(2);
		Payment payment = payments.get(String.valueOf(option));
		if(payment == null){
			throw new AssertionError("Método de pago inválido");
		}
		return payment;
	}

	//-- Seleccionar evento
	//-------------------------------------------------------------------------
	
	public Event selectEvent()
	{
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}
	
	public void showEvents()
	{
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}
	
	public void showEvent(Event event)
	{
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", 
				event.getAvailableTickets(), event.getPrice()));
	}
	
	
	//-- Pedir el número de entradas
	//-------------------------------------------------------------------------
	
	public int howManyTickets(int availableTickets)
	{
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}


	//-- Getters de los componentes
	//-------------------------------------------------------------------------

	public CardReader getCardReader(){
		return cardReader;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public Display getDisplay() {
		return display;
	}

	public Printer getPrinter() {
		return printer;
	}

	public BillAcceptor getBillAcceptor() {
		return billAcceptor;
	}

	public BankGateway getBankGateway() {
		return bankGateway;
	}

	public List<Event> getEvents(){
		return new ArrayList<>(events);
	}

	public Map<String,Payment> getPayments(){
		return new HashMap<>(payments);
	}

}
