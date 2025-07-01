package model.adapters;

import maps.Coordinates;
import maps.MapElement;
import model.Photo;

public class PhotoAdapter implements MapElement {

    private Photo photo;

    public PhotoAdapter(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String getTitle() {
        return photo.getDescription();
    }

    @Override
    public Coordinates getCoordinates() {
        return photo.getCoordinates();
    }

    @Override
    public String getHTMLInfo() {
        return photo.getDescription();
    }

    @Override
    public void open() {
        photo.show();
    }
}
