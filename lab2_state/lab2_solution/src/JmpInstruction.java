public class JmpInstruction implements Instruction {

    private int value;

    public JmpInstruction(int value) {
        this.value = value;
    }

    @Override
    public void execute(MyVirtualMachine vm) {
        vm.setIp(value);
    }
}
