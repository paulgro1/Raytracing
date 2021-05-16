package cgg.a03;

import cgtools.*;
import static cgtools.Vector.*;

public class Ray {

	public final Point x; // Ursprung
	public final Direction d; // Richtung
	public final double tMin = 0; // untere Begrenzung t
	public final double tMax = Double.POSITIVE_INFINITY; // obere Begrenzung t

	public Ray(Point x, Direction d) {
		this.x = x;
		this.d = d;
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
