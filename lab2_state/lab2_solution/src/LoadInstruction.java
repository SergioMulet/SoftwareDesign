public class LoadInstruction implements Instruction{

    @Override
    public void execute(MyVirtualMachine vm) {
        int address = vm.pop();
        vm.push(vm.getMemory()[address]);
        vm.setIp(-1);
    }
}
