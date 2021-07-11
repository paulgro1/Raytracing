package cgg.a11;

import static cgtools.Color.*;
import static cgtools.Matrix.multiply;
import static cgtools.Matrix.rotation;
import static cgtools.Matrix.translation;
import static cgtools.Vector.direction;
import static cgtools.Vector.point;

import java.io.IOException;
import java.util.ArrayList;

import cgg.Image;
import cgg.a03.Lochkamera;
import cgg.a03.Sphere;
import cgg.a04.Background;
import cgg.a04.Group;
import cgg.a04.GroupRaytracer;
import cgg.a04.Plane;
import cgg.a04.Shape;
import cgg.a05.BackgroundMaterial;
import cgg.a05.DiffusedMaterial;
import cgg.a10.Constant;
import cgg.a10.Texture;
import cgtools.Color;
import cgtools.Direction;
import cgtools.Matrix;
import cgtools.Sampler;

public class MainA11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int width = 1280;
		final int height = 720;

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		ArrayList<Shape> shapes = new ArrayList<Shape>();

		Matrix l = multiply(rotation(0, 1, 0, -144), rotation(1, 0, 0, 43));
		Light l1 = new DirectionLight(multiply(l, direction(0, 0, 1)), Color.white);
		Light l2 = new PointLight(point(0, -1, 0), Color.multiply(new Color(0.6, 0.7, 1), 2.5));

		try {

			Shape background = new Background(new BackgroundMaterial(new Constant(black)));
			Shape ground = new Plane(point(0.0, -0.5, 0.0), direction(0, 1, 0),
					new DiffusedMaterial(new Constant(gray)));
			Shape globe1 = new Sphere(point(0.0, 0.2, -2.5), 0.7,
					new DiffusedMaterial(new Texture("./Textures/deathStar.jpeg")));

			shapes.add(background);
			shapes.add(ground);
			shapes.add(globe1);

			Group group = new Group(shapes);

			World w = new World(group, l1, l2);

			Lochkamera cam = new Lochkamera(Math.PI / 3, width, height,
					multiply(translation(2, 0, -2), rotation(new Direction(0, 1, 0), 60)));

			GroupRaytracer raytracer = new GroupRaytracer(w, 5, cam);

			// Abtastung
			image.sample(raytracer);

			String filename = "doc/a11-1.png";
			image.write(filename);
			System.out.println("Wrote image: " + filename);

			// Bild 2

			Shape globe2 = new Sphere(point(0.0, 0.2, -4), 0.7,
					new DiffusedMaterial(new Texture("./Textures/venus.png")));

			shapes.remove(ground);
			shapes.add(globe2);

			Group group2 = new Group(shapes);
			
			World w2 = new World(group2, l1, l2);
			
			GroupRaytracer raytracer2 = new GroupRaytracer(w2, 5, cam);

			// Abtastung
			image.sample(raytracer2);

			filename = "doc/a11-2.png";
			image.write(filename);
			System.out.println("Wrote image: " + filename);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
