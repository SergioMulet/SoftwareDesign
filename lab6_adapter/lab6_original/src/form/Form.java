package form;

import model.Monument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Form to edit two fields of an element.
//
public class Form {

	public void edit(Monument monument) {
		System.out.println("Editing the monument...");

		System.out.println("Current values:");
		printMonument(monument);

		System.out.println("New values (leave blank to keep current value):");
		System.out.print(" - Author: ");
		String value = readLine();
		if (value.length() > 0)
			monument.setAuthor(value);

		System.out.print(" - Address: ");
		value = readLine();
		if (value.length() > 0)
			monument.setAddress(value);

		System.out.println("Updated values:");
		printMonument(monument);
	}

	private void printMonument(Monument monument) {
		System.out.println(" - Author: " + monument.getAuthor());
		System.out.println(" - Address: " + monument.getAddress());
	}

	private String readLine() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				return console.readLine();
			} catch (IOException ex) {
				System.out.println("I/O error: try again.");
			}
		} while (true);
	}
}
