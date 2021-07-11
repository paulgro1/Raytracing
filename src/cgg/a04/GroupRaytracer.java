package cgg.a04;

import static cgtools.Color.*;
import static cgtools.Color.black;

import cgg.a03.Hit;
import cgg.a03.Lochkamera;
import cgg.a03.Ray;
import cgg.a05.DiffusedMaterial;
import cgg.a11.Light;
import cgg.a11.World;
import cgtools.Color;
import cgtools.Sampler;

public class GroupRaytracer implements Sampler {

	Group group;
	Lochkamera cam;
	int depth;
	World world;

	public GroupRaytracer(World world, int depth, Lochkamera cam) {
		this.world = world;
		this.depth = depth;
		this.cam = cam;
	}

	public Color getColor(double x, double y) {

		Ray ray = cam.createRay(x, y);
		return calculateRadiance(ray, world, depth);

	}

	public Color calculateRadiance(Ray ray, World world, int depth) {

		if (depth == 0)
			return black;

		Hit hit = world.scene.intersect(ray);

		Ray scatteredRay = hit.material.scatteredRay(ray, hit);

		if (scatteredRay != null) {
			Color radiance = calculateRadiance(scatteredRay, world, --depth);

			if (hit.material instanceof DiffusedMaterial) {
				for (Light l : world.lights) {
					Color luminance = l.incomingIntensity(hit.x, hit.n, world.scene);
					if (luminance != null)
						radiance = add(radiance, luminance);
				}
			}
			return add(hit.material.getEmission(hit), multiply(hit.material.getAlbedo(hit), radiance));
		}

		else {
			return hit.material.getEmission(hit);
		}

	}

}