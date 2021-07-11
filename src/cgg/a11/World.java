package cgg.a11;

import java.util.ArrayList;

import cgg.a04.Group;

public class World {

	public final ArrayList<Light> lights;
	public final Group scene;

	public World(Group scene, Light... lights) {
		this.scene = scene;
		this.lights = new ArrayList<Light>(lights.length);
		for (Light l : lights)
			this.lights.add(l);
	}

}
