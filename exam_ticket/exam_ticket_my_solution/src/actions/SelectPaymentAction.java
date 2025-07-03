package actions;

import machine.Machine;
import machine.Payment;

public class SelectPaymentAction implements Action<Payment>{

    private final Machine machine;

    public SelectPaymentAction(Machine machine) {
        this.machine = machine;
    }

    @Override
    public Payment execute() {
        machine.showPaymentModes();
        int option = machine.getKeyboard().readOption(2);
        Payment payment = machine.getPayments().get(String.valueOf(option));
        if(payment == null){
            throw new AssertionError("Método de pago inválido");
        }
        return payment;
    }
}
