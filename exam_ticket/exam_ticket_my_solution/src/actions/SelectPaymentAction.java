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
        return machine.selectPaymentMode();
    }
}
