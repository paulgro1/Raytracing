package cgg.a05;

import static cgtools.Color.*;
import static cgtools.Color.green;
import static cgtools.Color.red;
import static cgtools.Color.white;
import static cgtools.Vector.direction;
import static cgtools.Vector.point;
import static cgg.a06.Glass.*;

import java.util.ArrayList;

import cgg.Image;
import cgg.a03.Hit;
import cgg.a03.Ray;
import cgg.a03.Sphere;
import cgg.a04.Background;
import cgg.a04.Group;
import cgg.a04.GroupRaytracer;
import cgg.a04.Plane;
import cgg.a04.Shape;
import cgg.a06.Glass;
import cgg.a06.MetalMaterial;
import cgtools.Color;

public class MainA05 {

	public static void main(String[] args) {
		final int width = 640;
		final int height = 360;

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		ArrayList<Shape> shapes = new ArrayList<Shape>();

		Shape background = new Background(new BackgroundMaterial(white));
		Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0),
				new MetalMaterial(new Color(0.8, 0.8, 0.8), 0.8));
		Shape globe1 = new Sphere(point(-1.0, 0.2, -2.5), 0.7, new DiffusedMaterial(red));
		Shape globe2 = new Sphere(point(-0.25, -0.05, -1.5), 0.5, new Glass(white, 1.0, 1.5));
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

		String filename = "doc/a06-mirrors-glass-1.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

		shapes.add(new Sphere(point(1.5, 0.8, -2.5), 0.5, new Glass(green, 1.0, 1.5)));

		Group secGroup = new Group(shapes);
		GroupRaytracer secRaytracer = new GroupRaytracer(secGroup, 5);

		image.sample(secRaytracer);

		filename = "doc/a06-mirrors-glass-2.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

		System.out.println("A06 Tests:");

		System.out.println(reflect(direction(0.000, 0.000, 0.000), direction(0.000, 1.000, 0.000)));
		System.out.println(reflect(direction(0.707, -0.707, 0.000), direction(0.000, 1.000, 0.000)));
		System.out.println(reflect(direction(0.707, 0.707, 0.000), direction(0.000, 1.000, 0.000)));
		System.out.println(schlick(direction(0.707, 0.707, 0.000), direction(0.000, 1.000, 0.000), 1, 1.5));
		System.out.println(schlick(direction(0.707, 0.707, 0.000), direction(0.000, 1.000, 0.000), 1.5, 1));
		System.out.println(schlick(direction(0.995, -0.100, 0.000), direction(0.000, 1.000, 0.000), 1, 1.5));
		System.out.println(schlick(direction(0.995, -0.100, 0.000), direction(0.000, 1.000, 0.000), 1.5, 1));
		System.out.println(refract(direction(0.707, 0.707, 0.000), direction(0.000, 1.000, 0.000), 1, 1.5));
		System.out.println(refract(direction(0.707, 0.707, 0.000), direction(0.000, 1.000, 0.000), 1.5, 1));
		System.out.println(refract(direction(0.995, -0.100, 0.000), direction(0.000, 1.000, 0.000), 1, 1.5));
		System.out.println(refract(direction(0.995, -0.100, 0.000), direction(0.000, 1.000, 0.000), 1.5, 1));
		System.out.println(refract(direction(0.100, -0.995, 0.000), direction(0.000, 1.000, 0.000), 1, 1.5));
		System.out.println(refract(direction(0.100, -0.995, 0.000), direction(0.000, 1.000, 0.000), 1.5, 1));

	}

}
