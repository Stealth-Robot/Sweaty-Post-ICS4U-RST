/*
 * DialogCreator.java
 * when called, creates dialogue boxes
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package dialog;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gui.Display;
import gui.DrawImageOnCanvas.ImageLoader;

public class DialogCreator {

	public static void createDialog(String title, String text, int option) {
		JOptionPane.showMessageDialog(Display.mainFrame, text,title,option);
	}
	/**
	 * 
	 * @param title
	 * @param text
	 * @param option
	 * @param image
	 * @param buttons
	 * @return
	 */
	public static int createDialog(String title, String text, ImageIcon image, String... buttons) {
		int returnValue = JOptionPane.showOptionDialog(Display.mainFrame, text, title,
		        JOptionPane.NO_OPTION,-1,image, buttons, buttons[0]);
		System.out.println(returnValue);
		return returnValue;
	}

}
