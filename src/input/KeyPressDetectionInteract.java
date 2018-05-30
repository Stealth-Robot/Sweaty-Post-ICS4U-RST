package input;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import gui.Vector2;
import javafx.scene.input.KeyCode;

public class KeyPressDetectionInteract extends KeyAdapter {
	private boolean interacted;
	private boolean interactedfirst;
	/**
	 * Checks to see if the interact key is pressed
	 * @param e key event.
	 */
	public void keyPressed(KeyEvent e) {
		int keys = e.getKeyCode();

		if (keys == KeyEvent.VK_SPACE) interacted = true;
	}

	/**
	 * Checks to see when keys are released
	 * @param e key event.
	 */
	public void keyReleased(KeyEvent e) {
		int keys = e.getKeyCode();

		if (keys == KeyEvent.VK_SPACE) {
			interactedfirst = true;
			interacted = false;
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
	 * Returns true once the interact button
	 * 
	 * @param isX (true if x value is wanted. false if y value is wanted)
	 * @return
	 */
	public boolean processKeyEvent() {
		//Increases and decreases X and Y values when buttons are pressed
		if (interacted && interactedfirst) {
			System.out.println(true);
			interactedfirst = false;
			return true;
		} else {
			System.out.println(false);
			return false;
		}


	}
}
