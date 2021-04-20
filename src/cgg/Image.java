package cgg;

import cgtools.Color;
import cgtools.Sampler;

public class Image {

	int width;
	int height;
	double[] data;

	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		data = new double[width * height * 3];
	}

	public void setPixel(int x, int y, Color color) {
		int r = 3 * ( y * width + x ) + 0;
		int g = 3 * ( y * width + x ) + 1;
		int b = 3 * ( y * width + x ) + 2;
		data[r] = color.r;
		data[g] = color.g;
		data[b] = color.b;
		
	}

	public void write(String filename) {
		cgtools.ImageWriter.write(filename, data, width, height);
	}

	public void sample(Sampler s) {
		notYetImplemented();
	}

	private void notYetImplemented() {
		System.err.println("Please complete the implementation of class cgg.Image as part of assignment 1.");
		System.exit(1);
	}
}
