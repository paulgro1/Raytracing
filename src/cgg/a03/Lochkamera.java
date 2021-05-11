package cgg.a03;

import cgtools.*;
import static cgtools.Vector.*;

public class Lochkamera {

	double winkel;
	double height;
	double width;
	Point camera = point(0, 0, 0);

	public Lochkamera(double winkel, double width, double height) {
		this.winkel = winkel;
		this.height = height;
		this.width = width;
	}

	public Ray createRay(double x, double y) {

		double xd = x - width / 2;
		double yd = ((height / 2) - y);
		double zd = -((width / 2) / Math.tan(winkel / 2));

		return new Ray(camera, normalize(direction(xd, yd, zd)));
	}
}
