package videoclub;

public class ChildrenMovie implements Movie {

    private String title;

    public ChildrenMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getPrice(int daysRented) {
        double price = 1.5;
        if (daysRented > 3) {
            price += (daysRented - 3) * 1.5;
        }
        return price;
    }

    @Override
    public int addFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
