import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Instruction> instructions = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		loadInstructions();
		MyVirtualMachine vm = new MyVirtualMachine(instructions);

		vm.execute();
	}

	private static void loadInstructions() throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("../factorial.txt"));

		String line;
		while ((line = file.readLine()) != null)
			loadSentence(line);
		file.close();
	}

	private static void createInstruction(String[]sentence) {

		if (sentence[0].equals("push")) {
			instructions.add(new PushInstruction(Integer.parseInt(sentence[1])));
		} else if (sentence[0].equals("add")) {
			instructions.add(new AddInstruction());
		} else if (sentence[0].equals("sub")) {
			instructions.add(new SubInstruction());
		} else if (sentence[0].equals("mul")) {
			instructions.add(new MulInstruction());
		} else if (sentence[0].equals("jmp")) {
			instructions.add(new JmpInstruction(Integer.parseInt(sentence[1])));
		} else if (sentence[0].equals("jmpg")) {
			instructions.add(new JmpgInstruction(Integer.parseInt(sentence[1])));
		} else if (sentence[0].equals("load")) {
			instructions.add(new LoadInstruction());
		} else if (sentence[0].equals("store")) {
			instructions.add(new StoreInstruction());
		} else if (sentence[0].equals("input")) {
			instructions.add(new InputInstruction());
		} else if (sentence[0].equals("output")) {
			instructions.add(new OutputInstruction());
		}
	}

	private static void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;

		String[] sentence = line.split(" ");
		createInstruction(sentence);
	}

}
