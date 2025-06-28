package videoclub;

public interface Movie {
	
	String getTitle();

	double getPrice(int daysRented);

	int addFrequentRenterPoints(int daysRented);

}
