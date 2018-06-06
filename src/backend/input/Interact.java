package backend.input;

public class Interact {
	private static boolean pressed, rpressed = true;
	
	/**
	 * Returns true for the tick that the interaction took place in
	 * @return
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
