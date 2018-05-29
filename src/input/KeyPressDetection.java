package input;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gui.Vector2;

public class KeyPressDetection extends KeyAdapter {

	// checks if WASD key is pressed down
	public boolean LEFT_KEY_DOWN = false;
	public boolean RIGHT_KEY_DOWN = false;
	public boolean UP_KEY_DOWN = false;
	public boolean DOWN_KEY_DOWN = false;

	/**
	 * Sets the WASD boolean value to true if the key is pressed down
	 * @param e key event.
	 */
	public void keyPressed(KeyEvent e) {
		int keys = e.getKeyCode();
		if (keys == KeyEvent.VK_D) {
			RIGHT_KEY_DOWN = true;
		} if (keys == KeyEvent.VK_A) {
			LEFT_KEY_DOWN = true;
		} if (keys == KeyEvent.VK_W) {
			UP_KEY_DOWN = true;
		} if (keys == KeyEvent.VK_S) {
			DOWN_KEY_DOWN = true;
		}
	}

	/**
	 * Sets the WASD boolean value to false if the key is released
	 * @param e key event.
	 */
	public void keyReleased(KeyEvent e) {
		int keys = e.getKeyCode();

		if (keys == KeyEvent.VK_D) {
			RIGHT_KEY_DOWN = false;
		} if (keys == KeyEvent.VK_A) {
			LEFT_KEY_DOWN = false;
		} if (keys == KeyEvent.VK_W) {
			UP_KEY_DOWN = false;
		} if (keys == KeyEvent.VK_S) {
			DOWN_KEY_DOWN = false;
		}
	}

	/**
	 * Creates a KeyEvent to be used every tick
	 * @param e key event.
	 */
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Calculates the x & y value in terms of movaement direction
	 * 
	 * @param isX (true if x value is wanted. false if y value is wanted)
	 * @return
	 */
	public Vector2 processKeyEvent() {
		int x = 0, y = 0;
		if (UP_KEY_DOWN) y++;
		if (DOWN_KEY_DOWN) y--;
		if (LEFT_KEY_DOWN) x--;
		if (RIGHT_KEY_DOWN) x++;
		//		System.out.println(x + " | " + y);

		return new Vector2(x,y);
	}
}
