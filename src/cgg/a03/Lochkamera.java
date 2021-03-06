package cgg.a03;

import cgtools.*;

import static cgtools.Vector.*;
import static cgtools.Matrix.*;

public class Lochkamera {

	double winkel;
	double height;
	double width;
	Point camera = point(0, 0, 0);
	Matrix matrix;

	public Lochkamera(double winkel, double width, double height, Matrix matrix) {
		this.winkel = winkel;
		this.height = height;
		this.width = width;
		this.matrix = matrix;
	}

	public Lochkamera(double winkel, double width, double height) {
		this.winkel = winkel;
		this.height = height;
		this.width = width;
	}

	public Ray createRay(double x, double y) {
		if (matrix != null) {
			double xd = x - width / 2;
			double yd = ((height / 2) - y);
			double zd = -((height / 2) / Math.tan(winkel / 2));

			return new Ray(multiply(matrix, camera), multiply(matrix, normalize(direction(xd, yd, zd))), 0,
					Double.POSITIVE_INFINITY);
		} else {
			return new Ray(camera, normalize(calculateD(x, y)), 0, Double.POSITIVE_INFINITY);
		}
	}
	
	private Direction calculateD(double x, double y) {
		double dx = x - width/2.0;
		double dy = -(y - height/2.0);
		double dz = -((width/2.0)/Math.tan(winkel/2.0));
		return direction(dx, dy, dz);
	}
}
