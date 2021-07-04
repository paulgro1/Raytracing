package cgg.a10;

import java.io.IOException;

import cgtools.Color;
import cgtools.ImageTexture;
import cgtools.Sampler;

public class Texture implements Sampler {
	
	public final ImageTexture texture;
	
	public Texture(String filename) throws IOException {
		texture = new ImageTexture(filename);
	}

	@Override
	public Color getColor(double u, double v) {
		return texture.getColor(u, v);
	}
}