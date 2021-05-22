package cgg.a05;

import static cgtools.Color.*;
import static cgtools.Vector.direction;
import static cgtools.Vector.point;

import java.util.ArrayList;

import cgg.Image;
import cgg.a03.Sphere;
import cgg.a04.Background;
import cgg.a04.Group;
import cgg.a04.GroupRaytracer;
import cgg.a04.Plane;
import cgg.a04.Shape;
import cgtools.Color;

public class MainA05 {

	public static void main(String[] args) {
		final int width = 1280;
		final int height = 720;

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		ArrayList<Shape> shapes = new ArrayList<Shape>();

		Shape background = new Background(new BackgroundMaterial(white));
		Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), new DiffusedMaterial(gray));
		Shape globe1 = new Sphere(point(-1.0, 0.2, -2.5), 0.7, new DiffusedMaterial(red));
		Shape globe2 = new Sphere(point(-0.25, -0.05, -2), 0.5, new DiffusedMaterial(green));
		Shape globe3 = new Sphere(point(0.5, 0.2, -3), 0.7, new DiffusedMaterial(blue));

		shapes.add(background);
		shapes.add(ground);
		shapes.add(globe1);
		shapes.add(globe2);
		shapes.add(globe3);

		Group group = new Group(shapes);

		GroupRaytracer raytracer = new GroupRaytracer(group, 5);

		// Abtastung
		image.sample(raytracer);

		String filename = "doc/a05-diffuse-spheres.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

	}

}
