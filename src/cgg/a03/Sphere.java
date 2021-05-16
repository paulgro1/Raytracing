package cgg.a03;

import static cgtools.Vector.*;

import cgg.a04.Shape;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public class Sphere implements Shape{

	Point center;
	double r;
	Color color;

	public Sphere(Point center, double r, Color color) {
		this.center = center;
		this.r = r;
		this.color = color;
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

//			System.out.println();
//			System.out.println(s.toString());
//			System.out.println(dNormalized.toString());
			return new Hit(t, s, dNormalized, color);
		} else

			return null;
	}

}
