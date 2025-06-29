public class OutputInstruction implements Instruction {


    @Override
    public void execute(MyVirtualMachine vm) {
        System.out.println(vm.pop());
        vm.setIp(-1);
    }
}
