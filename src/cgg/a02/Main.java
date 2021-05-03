package cgg.a02;

import cgg.Image;

public class Main {

	public static void main(String[] args) {
		final int width = 480;
		final int height = 270;

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		// Abtastung
		image.sample(new ColoredDiscs(width, height, 200));

		// Write the image to disk.
		String filename = "doc/a02-discs.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

		image.sample(new ColoredDiscs(width, height, 200)); 

		filename = "doc/a02-discs-supersampling.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

	}
}
