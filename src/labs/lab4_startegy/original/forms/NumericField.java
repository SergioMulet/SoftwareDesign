package labs.lab4_startegy.original.forms;

import java.io.*;

public class NumericField implements Field {

	private String label;
	private String value;

	public NumericField(String label) {
		this.label = label;
	}

	public void askUser() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		boolean isValid;
		do {
			isValid = true;
			try {
				System.out.print(label + ": ");
				value = console.readLine();

				for (char ch : value.toCharArray()) {
					if (!Character.isDigit(ch)) {
						isValid = false;
						break;
					}
				}
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!isValid);
	}

	public String getValue() {
		return value;
	}
}
