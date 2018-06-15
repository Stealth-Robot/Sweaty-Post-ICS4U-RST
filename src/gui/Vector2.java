/*
 * Vector2.java
 * generates a vector based off of two variables
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui;

public class Vector2 {

	public double x;
	public double y;
	public Vector2(double d, double e) {
		this.x = d;
		this.y = e;
	}
	public String toString() {
		return (x + ", " + y);
	}
}
