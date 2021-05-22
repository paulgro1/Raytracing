package cgg.a05;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgtools.Color;

public class BackgroundMaterial implements Material {

	Color emission;

	public BackgroundMaterial(Color emission) {
		this.emission = emission;
	}

	@Override
	public Color getEmission(Hit hit) {
		// TODO Auto-generated method stub
		return emission;
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
