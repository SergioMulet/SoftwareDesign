package model.adapters;

import maps.Coordinates;
import maps.GPS;
import maps.MapElement;
import model.Restaurant;

public class RestaurantAdapter implements MapElement {

    private Restaurant restaurant;
    private GPS gps = new GPS();

    public RestaurantAdapter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String getTitle() {
        return restaurant.getName();
    }

    @Override
    public Coordinates getCoordinates() {
        return gps.getCoordinates(restaurant.getAddress());
    }

    @Override
    public String getHTMLInfo() {
        return restaurant.getPhone();
    }

    @Override
    public void open() {

    }
}
