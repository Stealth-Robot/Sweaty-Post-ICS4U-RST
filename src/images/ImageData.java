/*
 * ImageData.java
 * allows manipulation of images
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package images;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import gui.Display;

public class ImageData {

	private Image image;
	private int xPos;
	private int yPos;
	
	private Image rightImage;
	private Image downImage;
	private Image leftImage;
	public ImageData(Image image, int xPos, int yPos) {
		this.image = image;
		this.xPos = xPos * Display.PIXEL_IMAGE_SIZE;
		this.yPos = (Display.SCREEN_HEIGHT - Display.PIXEL_IMAGE_SIZE) - (yPos * Display.PIXEL_IMAGE_SIZE);
		this.image = image.getScaledInstance(Display.PIXEL_IMAGE_SIZE, Display.PIXEL_IMAGE_SIZE, Image.SCALE_DEFAULT);
	}
	public void createRotationImages() {
		rightImage = rotateCw(toBufferedImage(this.image));
		downImage = rotateCw(toBufferedImage(rightImage));
		leftImage = rotateCw(toBufferedImage(downImage));
	}
	public static BufferedImage rotateCw( BufferedImage img )
	{
	    int         width  = img.getWidth();
	    int         height = img.getHeight();
	    BufferedImage   newImage = new BufferedImage( height, width, img.getType() );

	    for( int i=0 ; i < width ; i++ )
	        for( int j=0 ; j < height ; j++ )
	            newImage.setRGB( height-1-j, i, img.getRGB(i,j) );

	    return newImage;
	}
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
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
	public Image getRightImage() {
		return rightImage;
	}
	public Image getDownImage() {
		return downImage;
	}
	public Image getLeftImage() {
		return leftImage;
	}
	
}
