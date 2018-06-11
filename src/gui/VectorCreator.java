package gui;

public class VectorCreator {

	public static Vector2 dimensionalVector2(double x, double y) {
		return new Vector2(x * Display.PIXEL_IMAGE_SIZE, y * Display.PIXEL_IMAGE_SIZE);
	}
}
