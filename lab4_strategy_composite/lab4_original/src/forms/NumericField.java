package forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
