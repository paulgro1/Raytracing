package cgg.a04;

import static cgtools.Vector.direction;
import static cgtools.Vector.normalize;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgtools.Color;

public class Background implements Shape {

	Color color;

	public Background(Color color) {
		this.color = color;
	}

	@Override
	public Hit intersect(Ray ray) {

		if (ray.tMax == Double.POSITIVE_INFINITY) {
			Hit hit = new Hit(Double.POSITIVE_INFINITY, ray.pointAt(0), normalize(direction(1, 1, 1)), color);
			return hit;
		} else
			return null;
	}

}
