package videoclub;

public class RegularMovie implements Movie{

    String title;

    public RegularMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getPrice(int daysRented) {
        double price = 2;
        if(daysRented > 2){
            price += (daysRented - 2) * 1.5;
        }
        return price;
    }

    @Override
    public int addFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
