package backend.player;

import gui.Vector2;

public class MovementFromInputs {
	//Movement coordinates
	static public boolean RightPressed;
	static public boolean LeftPressed;
	static public boolean UpPressed;
	static public boolean DownPressed;	
	
	private static double x;
	private static double y;
	
	static public Vector2 getPositionRelativeToInputs() {
		x = 0;
		y = 0;
		if (RightPressed) x++;
		if (LeftPressed) x--;
		if (UpPressed) y++;
		if (DownPressed) y--;
		
		return new Vector2(x, y);
	}
	
	/**
	 * @return x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @return Vector2(x, y)
	 */
	public Vector2 getPosition() {
		return new Vector2(x, y);
	}
	
	/**
	 * increases the x value
	 */
	public void increaseX() {
		x++;
	}
	
	/**
	 * increase the y value
	 */
	public void increaseY() {
		y++;
	}
	
	/**
	 * decreases the x value
	 */
	public void decreaseX() {
		x--;
	}
	
	/**
	 * decreases the y value
	 */
	public void decreaseY() {
		y--;
	}
}
