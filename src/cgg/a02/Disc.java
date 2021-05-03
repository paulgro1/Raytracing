package cgg.a02;

import cgtools.Color;

public class Disc {

	double xP;
	double yP;
	int r;
	Color color;

	public Disc(double xP, double yP, int r, Color color) {
		this.xP = xP;
		this.yP = yP;
		this.r = r;
		this.color = color;
	}

	public boolean isPointInDisc(double x, double y) {

		// Nach Kreisgleichung: (x-m1)^2 + (y-m2)^2 = r^2 (alle Punkte, die Abstand r
		// zum Mittelpunkt M besitzen)

		double xR = x - xP; // x Koordinate relativ zum Mittelpunkt des Bildes
		double yR = y - yP;

		// wenn xR^2 + yR^2 kleiner als r^2 (also quasi innerhalb des Radius liegen)
		if (Math.pow(Math.abs(xR), 2) + Math.pow(Math.abs(yR), 2) < Math.pow(r, 2)) {
			return true;
		}

		else {
			return false;
		}

	}

	public Color getColor(double x, double y) {
	
		return color;
	}

}
