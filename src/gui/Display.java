/*
 * Display.java
 * sets up the display for everything to be drawn on the screen
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import backend.input.KeyBindings;;

public class Display {
private static Draw canvas;
	public static final int SCREEN_WIDTH = 864;
	public static final int SCREEN_HEIGHT = 576;
	public static final int PIXEL_IMAGE_SIZE = 96;
	public static JFrame mainFrame;
    public Display() {
        initCanvas();
    }

    /*
     * initializes the canvas
     * Pre: canvas is not initialized
     * Post: is initialized
     */
    private void initCanvas() {
    	
    	//makes the jframe
    	  mainFrame = new JFrame("Sweaty Post");
		  mainFrame.setVisible(true);
		  mainFrame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		  mainFrame.setResizable(false);
		  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  // makes the canvas
		  canvas = new Draw();
	        canvas.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMaximumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        
	        canvas = KeyBindings.initKeyBindings(canvas);
	        
	        mainFrame.add(canvas);
	        
	      
	        mainFrame.pack();
	       mainFrame.requestFocus();
	       canvas.requestFocus();
	       
	       Toolkit toolkit = Toolkit.getDefaultToolkit();
	       Image image = toolkit.getImage("src/images/cursors/BulletCursor.png");
	       Cursor c = toolkit.createCustomCursor(image , new Point(mainFrame.getX(), mainFrame.getY()), "img");
	       mainFrame.setCursor (c);
    }

    /*
     * gets the canvas and returns it
     * pre:nothing
     * post:canvas returned
     */
    public JPanel getCanvas() {

        if(canvas == null)
        {
            System.out.println("Canvas is null");
            return null;
        }

        return canvas;
    }
}