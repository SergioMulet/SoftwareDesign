import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyVirtualMachine {
    private List<Instruction> instructions = new ArrayList<>();
    private int ip = 0;

    private int[] memory = new int[1024];

    private int[] stack = new int[32];
    private int sp = 0;

    private static Scanner console = new Scanner(System.in);

    public MyVirtualMachine(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void execute(){
        while(ip < instructions.size()){
            Instruction instruction = instructions.get(ip);
            instruction.execute(this);
        }
    }

    void push(int value) {
        stack[sp] = value;
        sp++;
    }

    int pop() {
        sp--;
        return stack[sp];
    }

    public void setIp(int ip){
        if(ip == -1){
            this.ip++;
        }
        else{
            this.ip = ip;
        }
    }

    public int[] getMemory(){
        return memory;
    }

    public void setMemory(int address, int value){
        this.memory[address] = value;
    }

    public Scanner getConsole(){
        return this.console;
    }
}
