package core;

import java.util.ArrayList;
import java.util.List;

public class Drawing  {

	private List<Figure> figures = new ArrayList<>();

	public void addFigure(Figure figure) {
		if(figure != null){
			figures.add(figure);
		}
	}

	public void draw() {
		for(Figure figure : figures){
			figure.draw();
		}
	}
}
