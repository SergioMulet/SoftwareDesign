public class AddInstruction implements Instruction{

    @Override
    public void execute(MyVirtualMachine vm) {
        vm.push(vm.pop() + vm.pop());
        vm.setIp(-1);
    }
}
