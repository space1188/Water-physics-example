package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	Game game;
	int WIDTH;
	int HEIGHT;

	public Window(Game game, int WIDTH, int HEIGHT) {

		this.game = game;
		this.WIDTH = 1336;
		this.HEIGHT = 798;

		JFrame frame = new JFrame("Learning");

		frame.setSize(this.WIDTH, this.HEIGHT);
		frame.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		frame.setMaximumSize(new Dimension(this.WIDTH, this.HEIGHT));
		frame.setMinimumSize(new Dimension(this.WIDTH, this.HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();
		frame.getContentPane().add(game);

		frame.setVisible(true);

		game.start();

	}

}
