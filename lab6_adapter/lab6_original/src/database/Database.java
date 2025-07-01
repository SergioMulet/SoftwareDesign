package database;

import maps.Coordinates;
import model.Monument;
import model.Photo;
import model.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Simula el acceso a la base de datos
public class Database {
	
	public Collection<Monument> selectMonuments() {
		List<Monument> monuments = new ArrayList<Monument>();
		monuments.add(new Monument("Colosseum", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia"));
		monuments.add(new Monument("Fontana di Trevi", "Niccolo Salvi", "Trevi (Piazza di), 00187 Roma, Italia"));
		return monuments;
	}

	public Collection<Photo> selectPhotos() {
		List<Photo> photos = new ArrayList<Photo>();
		photos.add(new Photo("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20)));
		photos.add(new Photo("Fontana di Trevi", "mariocutroneo", new Coordinates(40, 40)));
		return photos;
	}

	public Collection<Restaurant> selectRestaurants() {
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		restaurants.add(new Restaurant("La Taverna dei Fori Imperiali", 
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643"));
		restaurants.add(new Restaurant("Pane e Salame", "Santa Maria in Via 19, Roma, Italia", "+39 06 679 1352"));
		return restaurants;
	}
}
