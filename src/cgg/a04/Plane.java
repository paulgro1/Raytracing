package cgg.a04;

import static cgtools.Vector.add;
import static cgtools.Vector.dotProduct;
import static cgtools.Vector.length;
import static cgtools.Vector.multiply;
import static cgtools.Vector.normalize;
import static cgtools.Vector.subtract;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a05.Material;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public class Plane implements Shape {

	Point p;
	Direction n;
	double r = Double.POSITIVE_INFINITY;
//	Color color;
	Material material;

	public Plane(Point p, Direction n, double r, Material material) {
		this.p = p;
		this.n = n;
		this.r = r;
//		this.color = color;
		this.material = material;
	}

	public Plane(Point p, Direction n, Material material) {
		this.p = p;
		this.n = n;
//		this.color = color;
		this.material = material;
	}

	@Override
	public Hit intersect(Ray ray) {

		double d = dotProduct(ray.d, n);

		if (d == 0)
			return null;

		double t = dotProduct(subtract(p, ray.x), n) / d;

		if (ray.isValid(t)) {
			Point s = add(multiply(ray.d, t), ray.x);
			if (length(subtract(s, p)) < r) {
				Direction dNormalized = normalize(ray.d);
				Hit hit = new Hit(t, s, dNormalized, material);
				return hit;
			}
		}

		return null;

	}

}
