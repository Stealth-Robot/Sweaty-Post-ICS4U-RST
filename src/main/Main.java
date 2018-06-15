/*
 * Main.java
 * client code that runs the entire application
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
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
/*



*/