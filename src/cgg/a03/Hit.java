package cgg.a03;

import cgg.a05.Material;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;

public class Hit {

	public final double t; // strahlparameter

	public final Point x; // position des treffpunkts x

	public final Direction n; // normalenvektor

//	public final Color c; // farbe im treffpunkt

	public final double u;
	public final double v;

	public final Material material;

	public Hit(double t, Point x, Direction n, Material material) {
		this.t = t;
		this.x = x;
		this.n = n;
		this.u = 0;
		this.v = 0;
//		this.c = c;
		this.material = material;

	}

	public Hit(double t, Point x, Direction n, double u, double v, Material material) {
		this.t = t;
		this.x = x;
		this.n = n;
		this.u = u - Math.floor(u);
		this.v = v - Math.floor(v);
		this.material = material;

	}

}
