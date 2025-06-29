public class PushInstruction implements Instruction {
    int value;

    PushInstruction(int value) {
        this.value = value;
    }

    @Override
    public void execute(MyVirtualMachine vm) {
        vm.push(value);
        vm.setIp(-1);
    }
}
