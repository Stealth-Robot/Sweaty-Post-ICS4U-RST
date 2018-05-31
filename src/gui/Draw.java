package gui;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import main.Main;

@SuppressWarnings("serial")
public class Draw extends JPanel {
	public Draw() {
addKeyListener(new TAdapter());
	}

	boolean first = true;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
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
		} catch(Exception e) {
			System.out.println("PaintComponent ERROR catch");
				first = false;
				Thread thread = new Thread() {
					public void run() {
						while (true) {
							paintComponent(g);
							System.out.println("PaintComponent ERROR2 catch");
						}

					}
				};

				thread.start();			
		}
	}
	
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("ayy");
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	System.out.println("ayy");
        }
    }
}
