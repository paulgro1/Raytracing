package cgg.a01;

import static cgtools.Color.*;

import cgg.*;

public class Main {

	public static void main(String[] args) {
		final int width = 480;
		final int height = 270;

		// This class instance defines the contents of the image.
		ConstantColor content = new ConstantColor(gray);
		ColoredDisk colDisk = new ColoredDisk(red, height, width);
		PolkaDots polkaDots = new PolkaDots(black, height, width, 9, 16, 10);

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);
		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				// Sets the color for one particular pixel.
//        image.setPixel(x, y, content.getColor(x, y));
				image.setPixel(x, y, content.getColor(x, y));
			}
		}

		// Write the image to disk.
		String filename = "doc/a01-image.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				// Sets the color for one particular pixel.
				image.setPixel(x, y, colDisk.getColor(x, y));
			}
		}

		filename = "doc/a01-disc.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {
				// Sets the color for one particular pixel.
				image.setPixel(x, y, polkaDots.getColor(x, y));
			}
		}

		filename = "doc/a01-polka-dots.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}
}
