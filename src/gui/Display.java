package gui;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import input.KeyPressDetectionInteract;
import input.KeyPressDetectionMovement;

public class Display {
    private static Canvas canvas;
	public static final int SCREEN_WIDTH = 864;
	public static final int SCREEN_HEIGHT = 576;
	public static final int PIXEL_IMAGE_SIZE = 96;
	public static JFrame mainFrame;
	public static KeyPressDetectionMovement keyMovement;
	public static KeyPressDetectionInteract keyInteract;
    public Display() {
        initCanvas();
    }

    private void initCanvas() {
    	  mainFrame = new JFrame("SWEATY POST");
		  mainFrame.setVisible(true);
		  mainFrame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		  mainFrame.setResizable(false);
		  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  canvas = new Canvas();
	        keyMovement = new KeyPressDetectionMovement();
	        keyInteract = new KeyPressDetectionInteract();
	        canvas.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMaximumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.addKeyListener(keyMovement);
	        canvas.addKeyListener(keyInteract);
	        
	        mainFrame.add(canvas);
	        mainFrame.pack();

    }

    public Canvas getCanvas() {

        if(canvas == null)
        {
            System.out.println("Canvas is null");
            return null;
        }

        return canvas;
    }
}