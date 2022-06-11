package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	Window window;
	public static final int WIDTH = 1330, HEIGHT = 763;
	protected boolean running = false;
	ArrayList<Mover> movers;
	Random random = new Random();

	int howManyMovers = 250;

	Thread thread;
	Liquid liquid;

	public Game() {

		window = new Window(this, WIDTH, HEIGHT);
		movers = new ArrayList<Mover>();
		liquid = new Liquid(0, HEIGHT / 2, WIDTH, HEIGHT / 2, 1.5, 100);

		for (int i = 0; i < howManyMovers; i++) {
			movers.add(new Mover(random.nextDouble() * 30 + 10, 20, 20));
		}

	}

	public void update() {

		for (int i = 0; i < movers.size(); i++) {

			movers.get(i).update();
			Mover m = movers.get(i);
			
			if (m.isInside(liquid)) {
				m.drag(liquid);
			}

		}

	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		/////////////////////////////////////////

		for (int i = 0; i < movers.size(); i++) {
			movers.get(i).render(g);
		}
		
		liquid.render(g);

		/////////////////////////////////////////

		g.dispose();
		bs.show();

	}

	public void run() {

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			if (running) {
				render();
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}

		}

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();

		running = true;

	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		running = true;

	}

	public static void main(String[] args) {

		new Game();

	}

}
