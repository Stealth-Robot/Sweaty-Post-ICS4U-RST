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
	}

	public static void intro () {
		intro = "Welcome to Sweaty Post! you have accadently released a bunch of bad bois and you have been tasked with recatching them."
				+ "\nAlso try not to die while doing so because that means you will lose";
	}
}