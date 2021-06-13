package cgg.a04;

import static cgtools.Color.add;
import static cgtools.Color.black;
import static cgtools.Color.multiply;

import cgg.a03.Hit;
import cgg.a03.Lochkamera;
import cgg.a03.Ray;
import cgtools.Color;
import cgtools.Sampler;

public class GroupRaytracer implements Sampler {

	Group group;
	Lochkamera cam;
	int depth;
	

	public GroupRaytracer(Group group, int depth, Lochkamera cam) {
		this.group = group;
		this.depth = depth;
		this.cam = cam;
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
			return add(multiply(calculateRadiance(group, scatteredRay, depth), hit.material.getAlbedo(hit)), hit.material.getEmission(hit));

		else
			return hit.material.getEmission(hit);
	}

}