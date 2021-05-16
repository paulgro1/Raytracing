package cgg.a04;

import cgg.a03.Hit;
import cgg.a03.Lochkamera;
import cgg.a03.Ray;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Sampler;
import cgtools.Util;

public class GroupRaytracer implements Sampler {

	Group group;
	Lochkamera cam = new Lochkamera(Math.PI / 3, 1280, 720);

	public GroupRaytracer(Group group) {
		this.group = group;
	}

	public Color getColor(double x, double y) {

		Ray ray = cam.createRay(x, y);
		Hit hit = group.intersect(ray);

		if (hit != null) {
			return Util.shade(hit.n, hit.c);
		}
		return Color.black;

	}

}