package cgg.a05;

import static cgtools.Color.black;
import static cgtools.Vector.add;
import static cgtools.Vector.*;
import static cgtools.Random.*;
import static cgtools.Vector.normalize;

import java.util.Random;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Point;
import cgtools.Util;

public class DiffusedMaterial implements Material {

	Color albedo;

	public DiffusedMaterial(Color albedo) {
		this.albedo = albedo;
	}

	@Override
	public Color getEmission(Hit hit) {
		return black;
	}

	@Override
	public Color getAlbedo(Hit hit) {
		// einfaches albedo returnen?
		return albedo;

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
