package main;

import database.Database;
import maps.Map;
import model.Monument;
import model.Photo;
import model.Restaurant;
import model.adapters.MonumentAdapter;
import model.adapters.PhotoAdapter;
import model.adapters.RestaurantAdapter;

public class Main {
	
	public static void main(String[] args) {
		Database database = new Database();
		Map map = new Map();
		
		// 1. Add elements to the map
		System.out.println("\n 1. Adding elements to the map...");
		
		for (Monument monument : database.selectMonuments()) {
			map.add(new MonumentAdapter(monument));
		}
		
		for (Photo photo : database.selectPhotos()) {
			map.add(new PhotoAdapter(photo));
		}

		for (Restaurant restaurant : database.selectRestaurants()) {
			map.add(new RestaurantAdapter(restaurant));
		}

		// 2. Draw the map with all the markers
		System.out.println("\n 2. Show map:");
		
		map.draw();

		// 3. The user touches a marker to show information
		System.out.println("\n 3. Short touch: a tooltip is shown with a summary of the element");
		map.userTouch(160, 160); // Summary of the Colosseum
		map.userTouch(22, 21);   // Summary of the photo
		map.userTouch(219, 221); // Summary of the restaurant

		// 4. The user performs a long touch on each element
		System.out.println("\n 4. Long touch: an action is permormed for the element");
		map.userLongTouch(160, 158); // Navigate to the Colosseum
		map.userLongTouch(19, 22);   // Download the photo
		map.userLongTouch(222, 218); // Call the restaurant
	}
}
