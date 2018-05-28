package images;

import java.awt.Image;

import gui.Display;

public class ImageData {

	private Image image;
	private int xPos;
	private int yPos;
	
	public ImageData(Image image, int xPos, int yPos) {
		this.image = image;
		this.xPos = xPos * Display.PIXEL_IMAGE_SIZE;
		this.yPos = (Display.SCREEN_HEIGHT - Display.PIXEL_IMAGE_SIZE) - (yPos * Display.PIXEL_IMAGE_SIZE);
		this.image = image.getScaledInstance(Display.PIXEL_IMAGE_SIZE, Display.PIXEL_IMAGE_SIZE, Image.SCALE_DEFAULT);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
}
