package model;


import maps.Coordinates;

public class Photo {

	public Photo(String description, String user, Coordinates coordinates) {
		this.description = description;
		this.user = user;
		this.coordinates = coordinates;
	}

	public String getDescription() {
		return description;
	}

	public String getUser() {
		return user;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void show() {
		System.out.printf("Opening photo %s...\n",description);
	}
	
	private String description;
	
	// Information about the user who took the photo
	private String user;
	
	// Coordinates where the photo was taken
	private Coordinates coordinates;
}
