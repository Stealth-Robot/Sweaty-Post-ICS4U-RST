package dialog;

import javax.swing.JOptionPane;

import gui.Display;
import main.Main;

public class DialogCreator {

	public static void createDialog(String title, String text, int option) {
		JOptionPane.showMessageDialog(Display.mainFrame, text,title,option);
	}
	public static void createDialog(String title, String text) {
		JOptionPane.showMessageDialog(Display.mainFrame, text,title,JOptionPane.DEFAULT_OPTION);
	}
}
