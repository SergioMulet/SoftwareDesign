package labs.lab6_adapter.original.google.maps;

public class GPS {
	
	// Simulates Google Maps navigation: given an address it gives us the
	// directions to reach it.
	public void getDirectionsTo(String address) {
		System.out.println("GPS: Turn right [...] You have reached your destination" + address);
	}

	// Gets the coordinates of an address.
	public Coordinates getCoordinates(String address) {
		// Cálculo de relleno: simplmente devuelve la posición en función de la primera letra
		double number = (address.toLowerCase().charAt(0) - 'a') * 10 + 10;
		return new Coordinates(number, number);
	}

	// Gets the address of a set of coordinates.
	public String getAddress(Coordinates coordinates) {
		return coordinates.toString();
	}
}
