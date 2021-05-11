package cgg.a03;

import cgtools.*;

public class Hit {

	double t; // strahlparameter

	Point x; // position des treffpunkts x

	Direction n; // normalenvektor

	Color c; // farbe im treffpunkt

	public Hit(double t, Point x, Direction n, Color c) {
		this.t = t;
		this.x = x;
		this.n = n;
		this.c = c;

	}

}
