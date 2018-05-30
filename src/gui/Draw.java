package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import main.Main;

@SuppressWarnings("serial")
public class Draw extends JPanel {
	public Draw() {

	}

	boolean first = true;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Main.game.run(g);
		if (first) {
			first = false;
			Thread thread = new Thread() {
				public void run() {
					while (true) {
						paintComponent(g);
					}

				}
			};

			thread.start();
		}
	}
}
