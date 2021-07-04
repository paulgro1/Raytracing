package cgg.a05;

import static cgtools.Color.black;
import static cgtools.Random.random;
import static cgtools.Vector.add;
import static cgtools.Vector.direction;
import static cgtools.Vector.length;
import static cgtools.Vector.normalize;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Sampler;
import cgtools.Util;

public class DiffusedMaterial implements Material {

	Sampler albedo;

	public DiffusedMaterial(Sampler texture) {
		this.albedo = texture;
	}

	@Override
	public Color getEmission(Hit hit) {
		return black;
	}

	@Override
	public Color getAlbedo(Hit hit) {

		// return albedo;
		return albedo.getColor(hit.u, hit.v);

	}

	@Override
	public Ray scatteredRay(Ray ray, Hit hit) {

		Direction r = direction(-1 + random() * 2, -1 + random() * 2, -1 + random() * 2);

		Direction d = normalize(add(hit.n, r));

		if (length(d) < 1)

			return new Ray(hit.x, d, Util.EPSILON, Double.POSITIVE_INFINITY);

		else
			return scatteredRay(ray, hit);

	}

}
