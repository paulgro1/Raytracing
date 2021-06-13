package cgg.a07;

import static cgtools.Color.*;
import static cgtools.Vector.direction;
import static cgtools.Vector.point;
import static cgtools.Matrix.*;
import static cgtools.Random.random;

import java.util.ArrayList;

import javax.swing.text.PlainDocument;

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
import cgg.a06.MetalMaterial;
import cgtools.Color;

public class MainA07 {

	public static void main(String[] args) {
		final int width = 1280;
		final int height = 720;

		Image image = new Image(width, height);

		ArrayList<Shape> shapes = new ArrayList<Shape>();

		Shape background = new Background(new BackgroundMaterial(new Color(0.0,0.0,0.2)));
		
		shapes.add(background);
		
		for(int i = 0; i < 800; i ++) {
			shapes.add(new Sphere(point(random() * 4 - 2, random() * 2 - 1, random() * 2 - 2), 0.003, new BackgroundMaterial(white)));
			
		}

		Shape sun = new Sphere(point(-0.75, 0.25, -1), 0.2, new BackgroundMaterial(yellow));
		
		Shape merkur = new Sphere(point(-0.3, 0.25, -1), 0.05, new DiffusedMaterial(brown));
		
		Shape venus = new Sphere(point(-0.15, 0.25, -1), 0.05, new DiffusedMaterial(orange));
		
		Shape earth = new Sphere(point(0, 0.25, -1), 0.05, new DiffusedMaterial(new Color(0.0,0.24,1)));
		
		Shape mars = new Sphere(point(0.15, 0.25, -1), 0.05, new DiffusedMaterial(new Color(0.42,0.26,15)));
		
		Shape jupiter = new Sphere(point(0.375, 0.25, -1), 0.1, new DiffusedMaterial(orange));
		
		Shape saturn = new Sphere(point(0.6, 0.25, -1), 0.075, new DiffusedMaterial(beige));
		
		Shape uranus = new Sphere(point(0.8, 0.25, -1), 0.05, new DiffusedMaterial(new Color(0.46,0.93,0.78)));
		
		Shape neptun = new Sphere(point(0.95, 0.25, -1), 0.05, new DiffusedMaterial(new Color(0.48,0.66,87)));


		shapes.add(sun);
		shapes.add(merkur);
		shapes.add(venus);
		shapes.add(earth);
		shapes.add(mars);
		shapes.add(jupiter);
		shapes.add(saturn);
		shapes.add(uranus);
		shapes.add(neptun);


		Group group = new Group(shapes);

		Lochkamera cam = new Lochkamera(Math.PI / 3, width, height,
				rotation(1, 0, 0, 10));
		
		Lochkamera cam2 = new Lochkamera(Math.PI / 3, width, height,
				multiply(translation(1, 0.25, -0.9), rotation(0, 1, 0, 60)));

		GroupRaytracer raytracer = new GroupRaytracer(group, 5, cam);
		
		GroupRaytracer raytracer2 = new GroupRaytracer(group, 5, cam2);

		
		image.sample(raytracer);

		String filename = "doc/a07-1.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
		
		image.sample(raytracer2);

		filename = "doc/a07-2.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
	}
}
