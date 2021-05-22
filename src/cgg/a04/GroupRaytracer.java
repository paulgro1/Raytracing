package cgg.a04;

import static cgtools.Color.*;

import cgg.a03.Hit;
import cgg.a03.Lochkamera;
import cgg.a03.Ray;
import cgtools.Color;
import cgtools.Sampler;

public class GroupRaytracer implements Sampler {

	Group group;
	Lochkamera cam = new Lochkamera(Math.PI / 3, 1280, 720);
	int depth;

	public GroupRaytracer(Group group, int depth) {
		this.group = group;
		this.depth = depth;
	}

	public Color getColor(double x, double y) {

		Ray ray = cam.createRay(x, y);
		return calculateRadiance(group, ray, depth);

	}

	public Color calculateRadiance(Shape group, Ray ray, int depth) {

		if (depth == 0)
			return black;

		Hit hit = group.intersect(ray);

		Ray scatteredRay = hit.material.scatteredRay(ray, hit);

		if (scatteredRay != null)
			return multiply(add(hit.material.getEmission(hit), hit.material.getAlbedo(hit)),
					calculateRadiance(group, scatteredRay, depth - 1));
		else
			return hit.material.getEmission(hit);
	}

}