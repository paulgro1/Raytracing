package cgg.a04;

import java.util.ArrayList;

import cgg.a03.Hit;
import cgg.a03.Ray;

public class Group implements Shape {

	ArrayList<Shape> shapes = new ArrayList<Shape>();

	public Group(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	@Override
	public Hit intersect(Ray ray) {

		Hit closest = null;

		for (Shape shape : shapes) {

			Hit current = shape.intersect(ray);

			if (current != null) {

				if (closest == null)

					closest = current;

				else if (current.t < closest.t)

					closest = current;
			}
		}

		return closest;

	}

}
