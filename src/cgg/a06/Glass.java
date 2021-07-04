package cgg.a06;

import static cgtools.Color.black;
import static cgtools.Random.random;
import static cgtools.Vector.add;
import static cgtools.Vector.dotProduct;
import static cgtools.Vector.multiply;
import static cgtools.Vector.negate;
import static cgtools.Vector.normalize;
import static cgtools.Vector.subtract;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a05.Material;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Sampler;
import cgtools.Util;

public class Glass implements Material {
	Sampler albedo;
	double inRefracIndex;
	double outRefracIndex;

	public Glass(Sampler texture, double inRefracIndex, double outRefracIndex) {
		this.albedo = texture;
		this.inRefracIndex = inRefracIndex;
		this.outRefracIndex = outRefracIndex;
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

	public static Direction refract(Direction d, Direction n, double n1, double n2) {
		//Brechungsgesetz
		double r = n1 / n2;
		double c = -dotProduct(n, d);
		double discriminant = 1 - (r * r) * (1 - (c * c));
		if (discriminant < 0) //Totalreflexion nur bei negativer Diskriminanten
			return null;
		else
			return add(multiply(r, d), multiply(r * c - Math.sqrt(discriminant), n));

	}

	public static Direction reflect(Direction d, Direction n) {
		return subtract(d, multiply(2 * dotProduct(n, d), n));
	}

	public static double schlick(Direction d, Direction n, double n1, double n2) {
		//Spekularer Reflexionsfaktor r
		double r0 = Math.pow((n1 - n2) / (n1 + n2), 2);
		return r0 + (1 - r0) * Math.pow(1 + dotProduct(n, d), 5);
	}

	@Override
	public Ray scatteredRay(Ray ray, Hit hit) {

		double n1, n2;
		Direction n = normalize(hit.n);

		if (dotProduct(n, normalize(ray.d)) > 0) {
			n = negate(n);
			n1 = inRefracIndex;
			n2 = outRefracIndex;
		} else {
			n1 = outRefracIndex;
			n2 = inRefracIndex;
		}

		Direction dt = refract(normalize(ray.d), n, n1, n2);
		if (dt != null && random() > schlick(normalize(ray.d), n, n1, n2))
			// then refract
			return new Ray(hit.x, dt, Util.EPSILON, Double.POSITIVE_INFINITY);
		else // reflect
			return new Ray(hit.x, reflect(normalize(ray.d), n), Util.EPSILON, Double.POSITIVE_INFINITY);

	}

}