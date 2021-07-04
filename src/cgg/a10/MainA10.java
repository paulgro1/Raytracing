package cgg.a10;

import static cgtools.Color.white;
import static cgtools.Vector.*;
import static cgtools.Matrix.*;
import static cgtools.Direction.*;

import java.io.IOException;
import java.util.ArrayList;

import cgg.Image;
import cgg.a03.Lochkamera;
import cgg.a03.Sphere;
import cgg.a04.Background;
import cgg.a04.Group;
import cgg.a04.GroupRaytracer;
import cgg.a04.Shape;
import cgg.a05.BackgroundMaterial;
import cgg.a05.DiffusedMaterial;
import cgtools.Direction;
import cgtools.Sampler;

public class MainA10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int width = 1280;
		final int height = 720;

		// Creates an image and iterates over all pixel positions inside the image.
		Image image = new Image(width, height);

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		try {
		Sampler universe = new Texture("./Textures/universe.jpeg");

		Shape background = new Background(new BackgroundMaterial(new Constant(white)));
		Shape globe1 = new Sphere(point(0.0, 0.0, -2.5), 0.7, new DiffusedMaterial(new Texture("./Textures/deathStar.jpeg")));
		

		shapes.add(background);
		shapes.add(globe1);

		Group group = new Group(shapes);
		
		Lochkamera cam = new Lochkamera(Math.PI / 3, width, height, multiply(translation(2,0,-2), rotation(new Direction(0,1,0), 60)));

		GroupRaytracer raytracer = new GroupRaytracer(group, 5, cam);

		// Abtastung
		image.sample(raytracer);

		String filename = "doc/a10-1.png";
		image.write(filename);
		System.out.println("Wrote image: " + filename);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
