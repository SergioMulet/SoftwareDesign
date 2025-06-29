public class StoreInstruction implements Instruction {

    @Override
    public void execute(MyVirtualMachine vm) {
        int value = vm.pop();
        int address = vm.pop();
        vm.setMemory(address, value);
        vm.setIp(-1);
    }
}
