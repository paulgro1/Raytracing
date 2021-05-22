package cgg.a05;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgtools.Color;

public interface Material {

	public Color getEmission(Hit hit);

	public Color getAlbedo(Hit hit);

	public Ray scatteredRay(Ray ray, Hit hit);

}
