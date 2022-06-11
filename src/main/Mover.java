package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Mover {

	Random random = new Random();
	Color color;

	Vector location;
	Vector velocity;
	Vector acceleration;

	Vector wind;
	Vector gravity;
	Vector friction;

	int w;
	int h;

	double mass;
	int scale = 1;

	public Mover(double mass, int x, int y) {

		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

		location = new Vector(x, y);
		velocity = new Vector(0, 0);
		acceleration = new Vector(0, 0);

		this.mass = mass;

	}

	public Mover() {

		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

		location = new Vector(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT));
		velocity = new Vector(0, 0);
		acceleration = new Vector(0, 0);

		mass = 1;

	}

	public void applyForce(Vector force) {
		Vector f = force.get();
		f.div(mass);
		acceleration.add(f);
	}

	public void checkEdges() {

		w = (int) mass * scale;
		h = (int) mass * scale;

		if (location.x + w > Game.WIDTH) {
			location.x = (Game.WIDTH - w);
			velocity.x *= -1;
		}
		if (location.x < 0) {
			location.x = 0;
			velocity.x *= -1;
		}

		if (location.y + h > Game.HEIGHT) {
			location.y = Game.HEIGHT - h;
			velocity.y *= -1;
		}
		if (location.y < 0) {
			location.y = 0;
			velocity.y *= -1;
		}

	}

	public boolean isInside(Liquid l) {

		boolean yorn = false;

		if (location.x + w > l.x && location.x < l.x + l.w && location.y + h > l.y && location.y < l.y + l.h) {
			yorn = true;
		} else {
			yorn = false;
		}

		return yorn;

	}

	public void drag(Liquid l) {

		float speed = (float) velocity.mag();
		float dragMagnitude = (float) (l.c * (speed * speed));

		Vector drag = velocity.get();
		drag.mult(-1);
		drag.normalize();
		drag.mult(dragMagnitude);

		applyForce(drag);

	}

	public void update() {

		wind = new Vector(0.5, 0);
		gravity = new Vector(0, 0.1 * mass);

		double c = 0.5;
		friction = velocity.get();
		friction.mult(-1);
		friction.normalize();
		friction.mult(c);

		applyForce(wind);
		applyForce(gravity);
		applyForce(friction);

		velocity.add(acceleration);
		location.add(velocity);

		acceleration.mult(0);

		checkEdges();

	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int) location.x, (int) location.y, (int) mass * scale, (int) mass * scale);

	}

}
