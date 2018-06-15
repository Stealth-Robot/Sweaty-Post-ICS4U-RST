/*
 * VectorCreator.java
 * uses vector2 to generate sizes
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui;

public class VectorCreator {

	public static Vector2 dimensionalVector2(double x, double y) {
		return new Vector2(x * Display.PIXEL_IMAGE_SIZE, y * Display.PIXEL_IMAGE_SIZE);
	}
}
