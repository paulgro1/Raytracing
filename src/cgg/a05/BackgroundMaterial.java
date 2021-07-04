package cgg.a05;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a10.Constant;
import cgtools.Color;
import cgtools.Sampler;

public class BackgroundMaterial implements Material {

	public final Sampler emission;

	public BackgroundMaterial(Sampler texture) {
		this.emission = texture;
	}
	
	public BackgroundMaterial(Color color) {
		this(new Constant(color));
	}

	@Override
	public Color getEmission(Hit hit) {
		// TODO Auto-generated method stub
		return emission.getColor(hit.u, hit.v);
	}

	@Override
	public Color getAlbedo(Hit hit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ray scatteredRay(Ray ray, Hit hit) {
		// TODO Auto-generated method stub
		return null;
	}

}
