package main;

import java.util.ArrayList;

import gui.Display;
import gui.DrawImageOnCanvas;
import gui.objects.colliders.Collider;
import java.lang.Math;
//update
public class Main {
	public static ArrayList<Collider> sceneColliders = new ArrayList<Collider>();
	private static Display display;
	public static void main(String[] args) {
		  DrawImageOnCanvas game = new DrawImageOnCanvas();
		   game.start();
	}
}
