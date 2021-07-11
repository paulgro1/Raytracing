package cgg.a11;

import cgg.a04.Shape;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public interface Light {

	public Color incomingIntensity(Point x, Direction n, Shape s);

}
