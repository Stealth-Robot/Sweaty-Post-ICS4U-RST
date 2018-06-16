/*
 * MovementFromInputs.java
 * sets up movement based of of interact key pressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package backend.input;

import gui.Vector2;

public class MovementFromInputs {
	//Movement coordinates
	static public boolean RightPressed;
	static public boolean LeftPressed;
	static public boolean UpPressed;
	static public boolean DownPressed;	
	
	private static double x;
	private static double y;

	/**
	 * pre: coords for vector are received
	 * post: returns vector
	 */
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
	 * post: return x
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * post: return y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * post: return Vector2(x, y)
	 */
	public Vector2 getPosition() {
		return new Vector2(x, y);
	}
	
	/**
	 * post: increases the x value
	 */
	public void increaseX() {
		x++;
	}
	
	/**
	 * post: increase the y value
	 */
	public void increaseY() {
		y++;
	}
	
	/**
	 * post: decreases the x value
	 */
	public void decreaseX() {
		x--;
	}
	
	/**
	 * post: decreases the y value
	 */
	public void decreaseY() {
		y--;
	}
}
