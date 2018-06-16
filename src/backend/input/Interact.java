/*
 * Interact.java
 * sets up player interaction when a key is pressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package backend.input;

public class Interact {
	private static boolean pressed, rpressed = true;
	/**
	 * pre: button pressed
	 * post: Returns true for the tick that the interaction took place in
	 */
	public static boolean interacted() {
		if (pressed && rpressed) {
			rpressed = false;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * pre: none
	 * post: Set the button to be either pressed or not pressed
	 */
	public static void setPressed(boolean p) {
		pressed = p;
		if (!p) {
			rpressed = true;
		}
	}
}
