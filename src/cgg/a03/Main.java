package cgg.a03;

import static cgtools.Vector.direction;
import static cgtools.Vector.normalize;
import static cgtools.Vector.point;

import java.util.ArrayList;

import cgg.Image;
import cgg.a02.ColoredDiscs;
import cgtools.Color;

public class Main {

	public static void main(String[] args) {
		final int width = 480;
		final int height = 270;

		camTest();
		sphereTest();

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		ArrayList<Sphere> spheres = new ArrayList<Sphere>();
		Sphere s1 = new Sphere(point(0, 0, -100), 20, Color.red);
		Sphere s2 = new Sphere(point(-50, 0, -100), 20, Color.green);
		Sphere s3 = new Sphere(point(50, 0, -100), 20, Color.blue);
		spheres.add(s3);
		spheres.add(s2);
		spheres.add(s1);

		Raytracer raytracer = new Raytracer(spheres);

		// Abtastung
		image.sample(raytracer);

		String filename = "doc/a03-three-spheres.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}

	public static void camTest() {
		Lochkamera testCam = new Lochkamera(Math.PI / 2, 10, 10);

		System.out.println(testCam.createRay(5, 5).x);

		System.out.println(normalize(testCam.createRay(0, 0).d));

		System.out.println(normalize(testCam.createRay(5, 5).d));

		System.out.println(normalize(testCam.createRay(10, 10).d));
	}

	public static void sphereTest() {

		Sphere s1 = new Sphere(point(0, 0, -2), 1, Color.black);
		Sphere s2 = new Sphere(point(0, 0, -2), 1, Color.black);
		Sphere s3 = new Sphere(point(0, -1, -2), 1, Color.black);
		Sphere s4 = new Sphere(point(0, 0, -2), 1, Color.black);
		Sphere s5 = new Sphere(point(0, 0, -4), 1, Color.black);

		Ray r1 = new Ray(point(0, 0, 0), direction(0, 0, -1));
		Ray r2 = new Ray(point(0, 0, 0), direction(0, 1, -1));
		Ray r3 = new Ray(point(0, 0, 0), direction(0, 0, -1));
		Ray r4 = new Ray(point(0, 0, -4), direction(0, 0, -1));
		Ray r5 = new Ray(point(0, 0, 0), direction(0, 0, -1));
		r5.tMax = 2;

		s1.intersect(r1);
		s2.intersect(r2);
		s3.intersect(r3);
		s4.intersect(r4);
		s5.intersect(r5);

	}
}
