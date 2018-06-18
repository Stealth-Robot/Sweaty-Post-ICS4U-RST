/*
 * Draw.java
 * draws Main.game to screen
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui;

import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Main;

@SuppressWarnings("serial")
public class Draw extends JPanel {
	public static final int GAME_SPEED = 10000;
	boolean first = true;
	public void rpaint() {
		this.repaint();
	}
	public Draw() {
		startTime = System.currentTimeMillis();
	}
	private long startTime;
	private long currentTime;
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * Pre: graphics object, automatically called
	 * Post: the whole screen has been painted and tick has been called
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			
			if (Main.game != null) {
				Main.game.run(g);
			}
			if (first) {
				ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
				exec.scheduleAtFixedRate(new Runnable() {
				  @Override
				  public void run() {
					  rpaint();
				  }
				}, 0, 5, TimeUnit.MILLISECONDS);
				first = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("PaintComponent ERROR catch");
		}
	}
}
