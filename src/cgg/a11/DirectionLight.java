package cgg.a11;

import static cgtools.Color.*;
import static cgtools.Vector.*;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a04.Shape;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;
import cgtools.Util;


public class DirectionLight implements Light {
	
	Direction d;
	Color c;

	public DirectionLight(Direction d, Color c) {
		this.d = normalize(d);
		this.c = c;
	}

	@Override
	public Color incomingIntensity(Point x, Direction n, Shape s) {
		
		double cos = dotProduct(negate(d), n);
		if (cos > 0) {
			Hit hit = s.intersect(new Ray(x, negate(d), Util.EPSILON, Double.MAX_VALUE));
			if(hit == null) return multiply(c, cos);
		}
		return null;
		
	}
}
