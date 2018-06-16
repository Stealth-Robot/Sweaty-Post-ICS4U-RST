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
import main.Main;

public class DialogCreator {

	public static void createDialog(String title, String text, int option) {
		JOptionPane.showMessageDialog(Display.mainFrame, text,title,option);
	}
	/**
	 * pre: values are passed
	 * post:
	 * @param title
	 * @param text
	 * @param option
	 * @param image
	 * @param buttons
	 * are created
	 */
	public static int createDialog(String title, String text, ImageIcon image, String... buttons) {
		buttons = Main.game.player.say(buttons);
		int returnValue = JOptionPane.showOptionDialog(Display.mainFrame, Main.game.player.say(text),  Main.game.player.say(title),
		        JOptionPane.NO_OPTION,-1,image,buttons , buttons[0]);
		return returnValue;
	}

}
