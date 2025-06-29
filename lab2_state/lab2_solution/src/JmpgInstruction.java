public class JmpgInstruction implements Instruction {

    private int value;

    public JmpgInstruction(int value) {
        this.value = value;
    }

    @Override
    public void execute(MyVirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        if(a>b){
            vm.setIp(value);
        }
        else{
            vm.setIp(-1);
        }
    }
}
