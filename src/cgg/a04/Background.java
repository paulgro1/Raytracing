package cgg.a04;

import static cgtools.Vector.direction;
import static cgtools.Vector.normalize;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a05.Material;
import cgtools.Color;

public class Background implements Shape {

//	Color color;
	Material material;

	public Background(Material material) {
//		this.color = color;
		this.material = material;
	}

	@Override
	public Hit intersect(Ray ray) {

		if (ray.tMax == Double.POSITIVE_INFINITY) {
			Hit hit = new Hit(Double.POSITIVE_INFINITY, ray.pointAt(0), normalize(direction(1, 1, 1)), material);
			return hit;
		} else
			return null;
	}

}
