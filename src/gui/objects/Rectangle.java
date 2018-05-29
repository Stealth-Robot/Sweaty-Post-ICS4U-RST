package gui.objects;

import gui.Vector2;

public class Rectangle {

	private int length;
	private int width;
	private Vector2 position;
	public Rectangle(int length, int width, Vector2 position) {
		this.length = length;
		this.width = width;
		this.position = position;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public boolean getInside(Vector2 insideCheck) {
		return insideCheck.x >= position.x && insideCheck.x <= position.x + length 
				&& insideCheck.y >= position.y && insideCheck.y <= position.y + width;
	}
}
