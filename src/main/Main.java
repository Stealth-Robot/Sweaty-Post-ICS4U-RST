package main;

import dialog.DialogCreator;
import gui.DrawImageOnCanvas;


//update
public class Main {
	public static boolean paused = false;
	public static int i = 0;
	
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		game = new DrawImageOnCanvas();
		//new WildWest();
		//DialogCreator.createDialog("Character says:", "I'm not gay");
	}
}