public class SubInstruction implements Instruction {

    @Override
    public void execute(MyVirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a-b);
        vm.setIp(-1);
    }
}
