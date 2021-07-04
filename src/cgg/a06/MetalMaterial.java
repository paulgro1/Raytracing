package cgg.a06;

import static cgtools.Color.black;
import static cgtools.Random.random;
import static cgtools.Vector.add;
import static cgtools.Vector.direction;
import static cgtools.Vector.dotProduct;
import static cgtools.Vector.length;
import static cgtools.Vector.multiply;
import static cgtools.Vector.normalize;
import static cgtools.Vector.subtract;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a05.Material;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Sampler;
import cgtools.Util;

public class MetalMaterial implements Material {

	public final Sampler albedo;
	double s;

	public MetalMaterial(Sampler texture, double s) {
		this.albedo = texture;
		this.s = s;
	}

	@Override
	public Color getEmission(Hit hit) {
		// TODO Auto-generated method stub
		return black;
	}

	@Override
	public Color getAlbedo(Hit hit) {
		// TODO Auto-generated method stub
		return albedo.getColor(hit.u, hit.v);
	}

	@Override
	public Ray scatteredRay(Ray ray, Hit hit) {

		Direction r = subtract(ray.d, multiply(2 * dotProduct(hit.n, ray.d), hit.n));

		if (s == 0)
			return new Ray(hit.x, normalize(r), Util.EPSILON, Double.POSITIVE_INFINITY);

		Direction rs = normalize(add(r, multiply(s, direction(random() * 2 - 1, random() * 2 - 1, random() * 2 - 1))));

		if (dotProduct(rs, hit.n) < 0)
			return null;

		if (length(rs) < 1)
			return new Ray(hit.x, normalize(rs), Util.EPSILON, Double.POSITIVE_INFINITY);

		else
			return scatteredRay(ray, hit);

	}

}
