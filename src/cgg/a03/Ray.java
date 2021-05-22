package cgg.a03;

import cgtools.*;
import static cgtools.Vector.*;

public class Ray {

	public final Point x; // Ursprung
	public final Direction d; // Richtung
	public final double tMin; // untere Begrenzung t
	public final double tMax; // obere Begrenzung t

	public Ray(Point x, Direction d, double tMin, double tMax) {
		this.x = x;
		this.d = d;
		this.tMin = tMin;
		this.tMax = tMax;
	}

	public Point pointAt(double t) {

		if (isValid(t))
			return add(x, multiply(t, d));
		else
			return null;

	}

	public boolean isValid(double t) {

		if (t >= tMin && t <= tMax)
			return true;
		else
			return false;

	}

}
