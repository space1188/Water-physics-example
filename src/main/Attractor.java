package main;

import java.awt.Color;
import java.awt.Graphics;

public class Attractor {

	public static double mass;
	public static Vector location;
	int scale = 2;
	Color color = Color.GREEN;
	public static double G;

	public Attractor() {

		location = new Vector(Game.WIDTH / 2, Game.HEIGHT / 2);
		mass = 20;
		G = 20;

	}

	public Vector attract(Mover m) {

		Vector force = Vector.sub(location, m.location);

		double distance = force.mag();
		
		

		//if (distance <= 5) {
		//	distance = 5;
		//}
		
		//if (distance >= 30) {
		//	distance = 30;
		//}
		
		
		force.normalize();
		double strength = (G * ((mass * m.mass) / (distance * distance)));
		force.mult(strength);
		
		return force;

	}

	public void update() {

	}

	public void render(Graphics g) {

		g.setColor(color);
		g.fillOval((int) location.x, (int) location.y, 50, 50);

	}

}
