package main;

import gui.DrawImageOnCanvas;
import wildWest.WildWest;


//update
public class Main {
	public static boolean paused = false;
	public static int i = 0;
	
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		game = new DrawImageOnCanvas();
		new WildWest();
	}

}