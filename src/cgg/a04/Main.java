package cgg.a04;

import static cgtools.Color.*;
import static cgtools.Vector.color;
import static cgtools.Vector.direction;
import static cgtools.Vector.point;

import java.util.ArrayList;
import java.util.Random;

import cgg.Image;
import cgg.a03.Sphere;
import cgtools.Color;

public class Main {

	public static void main(String[] args) {
		final int width = 1280;
		final int height = 720;

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		ArrayList<Shape> shapes = new ArrayList<Shape>();

		Shape background = new Background(darkgrey);
		Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0), gray);
		Shape globe1 = new Sphere(point(-1.0, -0.25, -2.5), 0.7, red);
		Shape globe2 = new Sphere(point(0.0, -0.25, -2.5), 0.5, green);
		Shape globe3 = new Sphere(point(1.0, -0.25, -2.5), 0.7, blue);

		shapes.add(background);
		shapes.add(ground);
		shapes.add(globe1);
		shapes.add(globe2);
		shapes.add(globe3);

		System.out.println(shapes);

		Group group = new Group(shapes);

		GroupRaytracer raytracer = new GroupRaytracer(group);

		// Abtastung
		image.sample(raytracer);

		String filename = "doc/a04-3-spheres.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);

		ArrayList<Shape> myShapes = new ArrayList<Shape>();

		Shape myBackground = new Background(new Color(0.2, 0.4, 0.55));
		Shape grass = new Plane(point(0.0, -2.5, 0.0), direction(0, 1, 0), green);
		Shape middle = new Sphere(point(0.0, 0.25, -10), 0.35, black);
		Shape bMiddle = new Sphere(point(0.0, 0.25, -9), 0.2, new Color(0.4, 0.3, 0.1));

		Shape leaf1 = new Sphere(point(0.0, 0.9, -11), 0.8, red);
		Shape leaf2 = new Sphere(point(0.0, -0.4, -11), 0.8, red);
		Shape leaf3 = new Sphere(point(0.65, 0.25, -11.1), 0.8, red);
		Shape leaf4 = new Sphere(point(-0.65, 0.25, -11.1), 0.8, red);

		Shape stem = new Sphere(point(0.0, -1.25, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem1 = new Sphere(point(0.0, -1.25, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem2 = new Sphere(point(0.0, -1.55, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem3 = new Sphere(point(0.0, -1.85, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem4 = new Sphere(point(0.0, -2.15, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem5 = new Sphere(point(0.0, -2.45, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem6 = new Sphere(point(0.0, -2.75, -11.2), 0.3, new Color(0, 0.5, 0));
		Shape stem7 = new Sphere(point(0.0, -3.05, -11.2), 0.3, new Color(0, 0.5, 0));

		myShapes.add(myBackground);
		myShapes.add(grass);
		myShapes.add(middle);
		myShapes.add(bMiddle);
		myShapes.add(leaf1);
		myShapes.add(leaf2);
		myShapes.add(leaf3);
		myShapes.add(leaf4);
		myShapes.add(stem);
		myShapes.add(stem1);
		myShapes.add(stem2);
		myShapes.add(stem3);
		myShapes.add(stem4);
		myShapes.add(stem5);
		myShapes.add(stem6);
		myShapes.add(stem7);

		Group myGroup = new Group(myShapes);

		GroupRaytracer myRaytracer = new GroupRaytracer(myGroup);

		image.sample(myRaytracer);

		filename = "doc/a04-scene.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}

}
