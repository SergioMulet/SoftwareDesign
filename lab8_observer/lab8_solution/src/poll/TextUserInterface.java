package poll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextUserInterface {

	public void fill(Poll poll) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Valid answers: [yes] / [no]");

		while (true) {
			System.out.println();
			System.out.println(poll.getQuestion());
			System.out.print("> ");

			// Read the user's input (it doesn't check if the number of words is correct)
			String[] line = input.readLine().split(" ");

			if (line[0].equals("exit")) {
				System.out.println("Bye!");
				return;
			}

			if (line[0].equals("yes")) {
				poll.incrementYeses();
			}
			if (line[0].equals("no")) {
				poll.incrementNos();
			}
		}
	}
}

