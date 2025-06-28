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
			double thisAmount = 0;

			// Calculates the amount for each rental
			switch (each.getMovie().getPriceCode()) {
				case REGULAR -> {
					thisAmount += 2;
					if (each.getDaysRented() > 2)
						thisAmount += (each.getDaysRented() - 2) * 1.5;
				}
				case NEW_RELEASE -> {
					thisAmount += each.getDaysRented() * 3;
				}
				case CHILDRENS -> {
					thisAmount += 1.5;
					if (each.getDaysRented() > 3)
						thisAmount += (each.getDaysRented() - 3) * 1.5;
				}
			}

			// Adds frequent renter points
			frequentRenterPoints++;
			// An extra point for new release movies rented for more than 1 day
			if ((each.getMovie().getPriceCode() == NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

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
