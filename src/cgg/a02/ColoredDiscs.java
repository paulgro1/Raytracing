package cgg.a02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import cgtools.Color;
import cgtools.Sampler;

// Represents the contents of an image. Provides the same color for all pixels.
public class ColoredDiscs implements Sampler {

	ArrayList<Disc> discs = new ArrayList<Disc>();
	double width;
	double height;
	int n;

	public ColoredDiscs(double width, double height, int n) {

		for (int i = 0; i < n; i++) {

			discs.add(new Disc((Math.random() * (width - 1)) + 1, (Math.random() * (height - 1)) + 1,
					(int) (Math.random() * 40), new Color(Math.random(), Math.random(), Math.random())));
		}
		
		class SortCircles implements Comparator<Disc> {

			public int compare(Disc a1, Disc a2) {

				return a1.r - a2.r;
			}
		}
		
		Collections.sort(discs, new SortCircles());
		
		System.out.println(discs.size());
	}


	public Color getColor(double x, double y) {

		for (int i = 0; i < this.discs.size(); i++) {

			if (this.discs.get(i).isPointInDisc(x, y)) {

				return this.discs.get(i).getColor(x, y);
			}

		}
		return Color.white;
	}

	// Returns the color for the given position.

}
