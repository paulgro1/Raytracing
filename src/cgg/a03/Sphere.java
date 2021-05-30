package cgg.a03;

import static cgtools.Vector.add;
import static cgtools.Vector.dotProduct;
import static cgtools.Vector.multiply;
import static cgtools.Vector.normalize;
import static cgtools.Vector.subtract;

import cgg.a04.Shape;
import cgg.a05.Material;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public class Sphere implements Shape {

	Point center;
	double r;
//	Color color;
	Material material;

	public Sphere(Point center, double r, Material material) {
		this.center = center;
		this.r = r;
//		this.color = color;
		this.material = material;
	}

	public Hit intersect(Ray ray) {

		Direction newOrigin = subtract(ray.x, center);

		double a = dotProduct(ray.d, ray.d);
		double b = 2 * dotProduct(newOrigin, ray.d);
		double c = dotProduct(newOrigin, newOrigin) - r * r;

		if ((b * b - 4 * a * c) < 0 || (2 * a) == 0) {
			return null;
		}

		double t = (-b - Math.sqrt(b * b - (4 * a * c))) / 2 * a;

		if (ray.isValid(t)) {
			Point s = add(multiply(ray.d, t), ray.x);
			Direction dNormalized = normalize(subtract(s, center));

			return new Hit(t, s, dNormalized, material);
		} else

			return null;
	}

}
