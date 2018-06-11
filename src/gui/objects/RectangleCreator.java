package gui.objects;

import gui.Display;
import gui.Vector2;

public class RectangleCreator {

	public static Rectangle dimensionalRectangle(int length, int width, int x, int y) {
		return new Rectangle(length * Display.PIXEL_IMAGE_SIZE, width * Display.PIXEL_IMAGE_SIZE, new Vector2(x * Display.PIXEL_IMAGE_SIZE, y * Display.PIXEL_IMAGE_SIZE));
	}
	public static Rectangle colliderRectangle(double x, double y) {
		return new Rectangle(Display.PIXEL_IMAGE_SIZE, Display.PIXEL_IMAGE_SIZE, new Vector2(x * Display.PIXEL_IMAGE_SIZE, y * Display.PIXEL_IMAGE_SIZE));
	}
}
