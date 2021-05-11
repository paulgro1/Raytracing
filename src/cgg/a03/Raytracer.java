package cgg.a03;

import java.util.ArrayList;

import cgtools.*;
import static cgtools.Vector.*;

public class Raytracer implements Sampler {

	ArrayList<Sphere> spheres = new ArrayList<Sphere>();
	Lochkamera cam = new Lochkamera(Math.PI / 2, 480, 270);

	public Raytracer(ArrayList<Sphere> spheres) {
		this.spheres = spheres;
	}

	public Color getColor(double x, double y) {
		double t = Double.POSITIVE_INFINITY;
		Direction normal = null;
		Color color = null;
		Ray ray = cam.createRay(x, y);

		for (Sphere s : spheres) {
			Hit hit = s.intersect(ray);
			if (hit != null) {
				t = hit.t;
				normal = hit.n;
				color = hit.c;
			}
		}

		if (t != Double.POSITIVE_INFINITY) {
			return Util.shade(normal, color);
		} else {
			return Color.white;
		}

	}

}
