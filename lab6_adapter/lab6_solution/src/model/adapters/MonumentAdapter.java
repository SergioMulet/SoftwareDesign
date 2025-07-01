package model.adapters;

import maps.Coordinates;
import maps.GPS;
import maps.MapElement;
import model.Monument;

public class MonumentAdapter implements MapElement {
    private Monument monument;
    private GPS gps = new GPS();

    public MonumentAdapter(Monument monument) {
        this.monument = monument;
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public Coordinates getCoordinates() {
        return gps.getCoordinates(monument.getAddress());
    }

    @Override
    public String getHTMLInfo() {
        return "Monument: " + monument.getName() + " created by: " + monument.getAuthor();
    }

    @Override
    public void open() {
    }
}
