package cgg.a01;

import cgtools.Color;
import cgtools.Sampler;

//Represents the contents of an image. Provides the same color for all pixels.
public class ColoredDisk implements Sampler {

	int height;
	int width;
	Color color; // black

	public ColoredDisk(Color color, int height, int width) {
		this.color = color;
		this.height = height;
		this.width = width;
	}

	// Returns the color for the given position.
	public Color getColor(double x, double y) {

		// Nach Kreisgleichung: (x-m1)^2 + (y-m2)^2 = r^2 (alle Punkte, die Abstand r
		// zum Mittelpunkt M besitzen)

		double w2 = width / 2.0;
		double h2 = height / 2.0;
		double xc = x - w2; // x Koordinate relativ zum Mittelpunkt des Bildes
		double yc = y - h2;

		// wenn xc^2 + yc^2 kleiner als h2^2 (also quasi innerhalb des Radius liegen)
		if (Math.pow(Math.abs(xc), 2) + Math.pow(Math.abs(yc), 2) < Math.pow(h2, 2)) {
			return color;
		}

		else {
			return color.black;
		}

	}

}