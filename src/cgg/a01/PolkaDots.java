package cgg.a01;

import cgtools.*;
import cgtools.Sampler;
import static cgtools.Vector.*;

public class PolkaDots implements Sampler {

	double height;
	double width;
	double rows;
	double columns;
	double radius;
	Color color;

	public PolkaDots(Color color, int height, int width, int rows, int columns, double radius) {
		this.color = color;
		this.height = height;
		this.width = width;
		this.rows = rows;
		this.columns = columns;
		this.radius = radius;

	}

	// Returns the color for the given position.
	public Color getColor(double x, double y) {

		double sx = width / columns; // (Rasterbreite x)
		double sy = height / rows; // (Rasterhöhe y)
		double q = x / sx - Math.floor(x / sx); // x koordinate relativ zu zelle
		double qy = y / sy - Math.floor(y / sy); // y koordinate relativ zu zelle
		double xm = q - 0.5; // x Koordinate relativ zum Mittelpunkt des Bildes
		double ym = qy - 0.5; // y Koordinate relativ zum Mittelpunkt des Bildes

		// Kreisgleichung

		if (Math.pow(Math.abs(xm), 2) + Math.pow(Math.abs(ym), 2) < Math.pow(radius / sx, 2)) {
			double v = x / width;
			return Color.hsvToRgb(color(v, 1, 1));
		}

		else {
			return color;
			
		}

	}
}