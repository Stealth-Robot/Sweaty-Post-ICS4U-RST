package gui;
import java.awt.Dimension;

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

    private void initCanvas() {
    	
    	  mainFrame = new JFrame("Sweaty Post");
		  mainFrame.setVisible(true);
		  mainFrame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		  mainFrame.setResizable(false);
		  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  canvas = new Draw();
	        canvas.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMaximumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        
	        canvas = KeyBindings.initKeyBindings(canvas);
	        
	        mainFrame.add(canvas);
	        
	      
	        mainFrame.pack();
	       mainFrame.requestFocus();
	       canvas.requestFocus();
    }

    public JPanel getCanvas() {

        if(canvas == null)
        {
            System.out.println("Canvas is null");
            return null;
        }

        return canvas;
    }
}