package videoclub;

public class NewReleaseMovie implements Movie{

    private String title;

    public NewReleaseMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int addFrequentRenterPoints(int daysRented) {
        if(daysRented > 1)
            return 1;
        return 0;
    }
}
