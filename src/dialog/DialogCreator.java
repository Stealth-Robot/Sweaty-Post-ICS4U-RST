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

import backend.input.MovementFromInputs;
import gui.Display;
import gui.DrawImageOnCanvas.ImageLoader;
import main.Main;

public class DialogCreator {

	public static void createDialog(String title, String text, int option) {
		MovementFromInputs.RightPressed = false;
		MovementFromInputs.LeftPressed = false;
		MovementFromInputs.UpPressed = false;
		MovementFromInputs.DownPressed = false;	
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
		int returnValue = -1;
		if(MovementFromInputs.RightPressed == false && MovementFromInputs.LeftPressed == false && 
				MovementFromInputs.UpPressed == false && MovementFromInputs.DownPressed == false) {

			MovementFromInputs.RightPressed = false;
			MovementFromInputs.LeftPressed = false;
			MovementFromInputs.UpPressed = false;
			MovementFromInputs.DownPressed = false;	
			buttons = Main.game.player.say(buttons);
			Main.paused = true;
			returnValue = JOptionPane.showOptionDialog(Display.mainFrame, Main.game.player.say(text),  Main.game.player.say(title),
					JOptionPane.NO_OPTION,-1,image,buttons , buttons[0]);
			Main.paused = false;
		}
		return returnValue;
	}

}
