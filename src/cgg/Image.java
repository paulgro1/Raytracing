package cgg;

import cgtools.Color;
import cgtools.Sampler;

public class Image {

	int width;
	int height;
	double[] data;
	double gamma = 2.2;
	int n = 10;

	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		data = new double[width * height * 3];
	}

	public void setPixel(int x, int y, Color color) {
		int r = 3 * (y * width + x) + 0;
		int g = 3 * (y * width + x) + 1;
		int b = 3 * (y * width + x) + 2;

		data[r] = Math.pow(color.r, (1 / gamma));
		data[g] = Math.pow(color.g, (1 / gamma));
		data[b] = Math.pow(color.b, (1 / gamma));

	}

	public void write(String filename) {
		cgtools.ImageWriter.write(filename, data, width, height);
	}

	public void sample(Sampler s) {

		for (int x = 0; x != width; x++) {
			for (int y = 0; y != height; y++) {

				double valR = 0;
				double valG = 0;
				double valB = 0;

				for (int xi = 0; xi < n; xi++) {
					for (int yi = 0; yi < n; yi++) {
						double rx = cgtools.Random.random();
						double ry = cgtools.Random.random();
						double xs = x + (xi + rx) / n;
						double ys = y + (yi + ry) / n;

						double r = s.getColor(xs, ys).r;
						double g = s.getColor(xs, ys).g;
						double b = s.getColor(xs, ys).b;

						valR += (r / n) / n;
						valG += (g / n) / n;
						valB += (b / n) / n;
					}
				}

				setPixel(x, y, new Color(valR, valG, valB));

			}
		}
	}

	private void notYetImplemented() {
		System.err.println("Please complete the implementation of class cgg.Image as part of assignment 1.");
		System.exit(1);
	}
}
