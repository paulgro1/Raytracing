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

	public final Material material;

	public Hit(double t, Point x, Direction n, Material material) {
		this.t = t;
		this.x = x;
		this.n = n;
//		this.c = c;
		this.material = material;

	}

}
