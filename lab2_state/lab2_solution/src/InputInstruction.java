public class InputInstruction implements Instruction{

    @Override
    public void execute(MyVirtualMachine vm) {
        System.out.println("Escriba un número entero: ");
        vm.push(vm.getConsole().nextInt());
        vm.setIp(-1);
    }
}
