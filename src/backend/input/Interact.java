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
	 * Returns true for the tick that the interaction took place in
	 * @return
	 */
	public static boolean interacted() {
	//	System.out.print(pressed ? "True\n" : "");
		if (pressed && rpressed) {
			rpressed = false;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Set the button to be either pressed or not pressed
	 * @param pressed
	 */
	public static void setPressed(boolean p) {
		pressed = p;
		if (!p) {
			rpressed = true;
		}
	}
}
