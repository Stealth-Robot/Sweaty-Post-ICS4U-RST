package input;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gui.Vector2;

public class KeyPressDetectionMovement extends KeyAdapter {

	// checks if WASD keys or arrow keys are pressed down
	private boolean LEFT_KEY_DOWN = false;
	private boolean RIGHT_KEY_DOWN = false;
	private boolean UP_KEY_DOWN = false;
	private boolean DOWN_KEY_DOWN = false;

	/**
	 * Sets the WASD boolean value to true if the key is pressed down
	 * @param e key event.
	 */
	public void keyPressed(KeyEvent e) {
		//checks WASD or arrow keys and sets the value to true when the key is originally pressed
		//called once per press
		int keys = e.getKeyCode();
		if (keys == KeyEvent.VK_D || keys == KeyEvent.VK_RIGHT) {
			RIGHT_KEY_DOWN = true;
		} if (keys == KeyEvent.VK_A || keys == KeyEvent.VK_LEFT) {
			LEFT_KEY_DOWN = true;
		} if (keys == KeyEvent.VK_W || keys == KeyEvent.VK_UP) {
			UP_KEY_DOWN = true;
		} if (keys == KeyEvent.VK_S || keys == KeyEvent.VK_DOWN) {
			DOWN_KEY_DOWN = true;
		}
	}

	/**
	 * Sets the WASD boolean value to false if the key is released
	 * @param e key event.
	 */
	public void keyReleased(KeyEvent e) {
		//checks WASD or arrow keys and sets the value to false when the key is released after being pressed
		//Called once per release
		int keys = e.getKeyCode();

		if (keys == KeyEvent.VK_D || keys == KeyEvent.VK_RIGHT) {
			RIGHT_KEY_DOWN = false;
		} if (keys == KeyEvent.VK_A || keys == KeyEvent.VK_LEFT) {
			LEFT_KEY_DOWN = false;
		} if (keys == KeyEvent.VK_W || keys == KeyEvent.VK_UP) {
			UP_KEY_DOWN = false;
		} if (keys == KeyEvent.VK_S || keys == KeyEvent.VK_DOWN) {
			DOWN_KEY_DOWN = false;
		}
	}

	/**
	 * Creates a KeyEvent to be used every tick
	 * @param e key event.
	 */
	public void keyTyped(KeyEvent e) {
		//Nothing goes here
	}

	/**
	 * Calculates the x & y value in terms of movaement direction
	 * 
	 * @param isX (true if x value is wanted. false if y value is wanted)
	 * @return
	 */
	public Vector2 processKeyEvent() {
		//Increases and decreases X and Y values when buttons are pressed
		int x = 0, y = 0;
		if (UP_KEY_DOWN) y--;
		if (DOWN_KEY_DOWN) y++;
		if (LEFT_KEY_DOWN) x--;
		if (RIGHT_KEY_DOWN) x++;

		//		System.out.println(x + " | " + y);

		return new Vector2(x, y);
	}
}
