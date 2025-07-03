package machine.payment;

import machine.Machine;
import machine.Payment;

public class CardPayment implements Payment {

    @Override
    public boolean pay(Machine machine, double amount) {
        String cardNumber = machine.getCardReader().readCardNumber();
        boolean isValid = machine.getBankGateway().pay(cardNumber, amount);
        if (!isValid) {
            machine.getDisplay().show("Tarjeta rechazada\n");
            return false;
        }
        // pago correcto
        machine.getDisplay().show("Tarjeta aceptada: pago realizado con éxito\n");
        return true;
    }

    @Override
    public String getName() {
        return "Pago con tarjeta";
    }
}
