package cgg.a03;

import cgtools.*;

public class Hit {

	public final double t; // strahlparameter

	public final Point x; // position des treffpunkts x

	public final Direction n; // normalenvektor

	public final Color c; // farbe im treffpunkt

	public Hit(double t, Point x, Direction n, Color c) {
		this.t = t;
		this.x = x;
		this.n = n;
		this.c = c;

	}

}
