package gui;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import main.Main;

@SuppressWarnings("serial")
public class Draw extends JPanel {

	boolean first = true;
	public void rpaint() {
		this.repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			
			if (Main.game != null) {
				Main.game.run(g);
			}

			if (first) {
				first = false;
				Thread thread = new Thread() {
					public void run() {
						while (true) {
							rpaint();
						}

					}
				};

				thread.start();
			}
		} catch (Exception e) {
			// System.out.println("PaintComponent ERROR catch");
		}
	}
}
