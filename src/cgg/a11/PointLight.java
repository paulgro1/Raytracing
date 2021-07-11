package cgg.a11;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a04.Shape;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

import static cgtools.Vector.*;
import static cgtools.Color.*;
import static cgtools.Util.*;

public class PointLight implements Light {
	
	public final Point p;
	public final Color c;

	public PointLight(Point p, Color c) {
		this.p = p;
		this.c = c;
	}

	@Override
	public Color incomingIntensity(Point x, Direction n, Shape s) {
		
		Direction toLight = subtract(p, x);
		Direction normal = normalize(toLight);
		double length = length(toLight);

		Hit hit = s.intersect(new Ray(x, normal, EPSILON, length));

		if(hit == null) return multiply(divide(c, length*length), dotProduct(normal, n));
		else return null;
		
	}
}

