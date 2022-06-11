package main;

import java.awt.Color;
import java.awt.Graphics;

public class Liquid {

	int x, y, w, h, transparency;
	double c;

	public Liquid(int x, int y, int w, int h, double d, int transparency) {

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = d;
		this.transparency = transparency;

	}

	public void update() {

	}

	public void render(Graphics g) {

		g.setColor(new Color(175, 244, 255, transparency));
		g.fillRect((int) x, (int) y, (int) w, (int) h);

	}

}
