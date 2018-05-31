package gui;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import input.*;;

public class Display {
private static Draw canvas;
	public static final int SCREEN_WIDTH = 864;
	public static final int SCREEN_HEIGHT = 576;
	public static final int PIXEL_IMAGE_SIZE = 96;
	public static JFrame mainFrame;
    private static Action aAction, sAction, dAction, wAction, aActionRelease, dActionRelease, wActionRelease, sActionRelease;
    public Display() {
        initCanvas();
    }

    private void initCanvas() {
    	
    	  mainFrame = new JFrame("SWEATY POST");
		  mainFrame.setVisible(true);
		  mainFrame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		  mainFrame.setResizable(false);
		  mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		  canvas = new Draw();
	        canvas.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMaximumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        canvas.setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	        
	        aAction = new AAction();
	        sAction = new SAction();
	        dAction = new DAction();
	        wAction = new WAction();
	        aActionRelease = new AActionRelease();
	        sActionRelease = new SActionRelease();
	        dActionRelease = new DActionRelease();
	        wActionRelease = new WActionRelease();

	       
	        canvas.getInputMap().put(KeyStroke.getKeyStroke("A"), "doaAction");
	        canvas.getInputMap().put(KeyStroke.getKeyStroke("D"), "dodAction");
	        canvas.getInputMap().put(KeyStroke.getKeyStroke("W"), "dowAction");
	        canvas.getInputMap().put(KeyStroke.getKeyStroke("S"), "dosAction");
	        canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_A, 0,true)), "doaActionRelease");
	        canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_D, 0,true)), "dodActionRelease");
	        canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_W, 0,true)), "dowActionRelease");
	        canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_S, 0,true)), "dosActionRelease");

	        canvas.getActionMap().put( "doaAction", aAction );
	        canvas.getActionMap().put( "dosAction", sAction );
	        canvas.getActionMap().put( "dodAction", dAction );
	        canvas.getActionMap().put( "dowAction", wAction );
	        canvas.getActionMap().put( "doaActionRelease", aActionRelease );
	        canvas.getActionMap().put( "dosActionRelease", sActionRelease );
	        canvas.getActionMap().put( "dodActionRelease", dActionRelease );
	        canvas.getActionMap().put( "dowActionRelease", wActionRelease );
	        
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