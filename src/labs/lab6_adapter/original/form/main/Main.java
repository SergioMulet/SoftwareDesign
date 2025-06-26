package labs.lab6_adapter.original.form.main;

import labs.lab6_adapter.original.form.Form;
import google.maps.*;
import model.*;

public class Main {
	
	public static void main(String[] args) {
		Monument colosseum = new Monument("Colosseum", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia");
		Photo photoColosseum = new Photo("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20));
		Restaurant tavernaDeiFori = new Restaurant("La Taverna dei Fori Imperiali", 
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643");
		
		Form form = new Form();
		form.edit(colosseum);
		
		// Task 1. Edit the restaurant as well: you should be able to edit the name and the address
		
		// Task 2. Edit the photo as well (user and description)

		// Task 3. Edit the monument, but now the the name and the address
	}
}
