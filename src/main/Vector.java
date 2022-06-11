package main;

public class Vector {

	public double x, y;

	public Vector(double x, double y) {

		this.x = x;
		this.y = y;

	}
	
	public Vector get() {
		return new Vector(x, y);
	}

	public void add(Vector v) {
		this.x += v.x;
		this.y += v.y;
	}

	public Vector add(Vector v1, Vector v2) {
		double x = v1.x += v2.x;
		double y = v1.y += v2.y;
		return (new Vector(x, y));
	}

	public void sub(Vector v) {
		this.x -= v.x;
		this.y -= v.y;
	}

	public static Vector sub(Vector v1, Vector v2) {
		double x = v1.x - v2.x;
		double y = v1.y - v2.y;
		return (new Vector(x, y));
	}

	public void mult(Vector v) {
		this.x *= v.x;
		this.y *= v.y;
	}
	
	

	public static Vector mult(Vector v1, Vector v2) {
		double x = v1.x *= v2.x;
		double y = v1.y *= v2.y;
		return (new Vector(x, y));
	}
	
	public Vector mult2(Vector v1) {
		double x = this.x *= v1.x;
		double y = this.y *= v1.y;
		return (new Vector(x, y));
	}

	public void mult(double n) {
		this.x *= n;
		this.y *= n;
	}

	public void div(Vector v) {
		this.x /= v.x;
		this.y /= v.y;
	}

	public static Vector div(Vector v1, Vector v2) {
		double x = v1.x /= v2.x;
		double y = v1.y /= v2.y;
		return (new Vector(x, y));
	}

	public void div(double n) {
		this.x /= n;
		this.y /= n;
	}

	public double mag() {
		return Math.sqrt(x * x + y * y);
	}

	public void normalize() {
		double m = mag();
		if (m != 0) {
			div(m);
		}
	}

	public void limit(double limit) {
		if (x > limit)
			x = limit;
		if (y > limit)
			y = limit;

		if (x < -limit)
			x = -limit;
		if (y < -limit)
			y = -limit;
	}

	public void limit(Vector limit) {
		if (x > limit.x)
			x = limit.x;
		if (y > limit.y)
			y = limit.y;

		if (x < -limit.x)
			x = -limit.x;
		if (y < -limit.y)
			y = -limit.y;
	}

}
