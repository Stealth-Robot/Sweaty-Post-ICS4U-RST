package main;

import javax.swing.JOptionPane;

import gui.DrawImageOnCanvas;


//update
public class Main {
	public static boolean paused = false;
	public static int i = 0;
	static String intro;
	
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		game = new DrawImageOnCanvas();
		intro();
<<<<<<< HEAD
=======
		//new WildWest();
		//int i =DialogCreator.createDialog("The Title of the Character","The Story of the Text",null,"I wish this to be the case","I hate every single one of you");
>>>>>>> a26cc16953f53ff10c2bf8ff60f59574fe9de99a
	}

	public static void intro () {
		intro = "Welcome to Sweaty Post! you have accadently released a bunch of bad bois and you have been tasked with recatching them."
				+ "\nAlso try not to die while doing so because that means you will lose";
	}
}