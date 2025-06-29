package videoclub;

import java.util.ArrayList;
import java.util.List;


public class Customer {

	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

		for (Rental each : rentals) {
			double thisAmount = each.getPrice();

			// Adds frequent renter points
			frequentRenterPoints++;
			frequentRenterPoints += each.addFrequentRenterPoints();

			// Shows the amount for each rental
			result.append("\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n");
			totalAmount += thisAmount;
		}

		// Adds footer lines with total amount and frequent renter points
		result.append("Amount owed is " + totalAmount + "\n");
		result.append("You earned " + frequentRenterPoints + " frequent renter points");

		return result.toString();
	}

}
