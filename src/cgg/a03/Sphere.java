package cgg.a03;

import static cgtools.Vector.*;

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
			Point x = ray.pointAt(t);
			Direction n = normalize(divide(subtract(x, center), r));
			
			//Texturkoordinate Kugeloberfläche:
			
			double azimuth = Math.PI + Math.atan2(n.x, n.z);
			double inclination = Math.acos(n.y);
			double u = azimuth / (2 * Math.PI);
			double v = inclination / Math.PI;
			
			return new Hit(t, x, n, u, v, material);

		} else

			return null;
	}

}
