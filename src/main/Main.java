package main;

import java.util.ArrayList;

import gui.DrawImageOnCanvas;
import gui.objects.colliders.Collider;
//update
public class Main {
	public static ArrayList<Collider> sceneColliders = new ArrayList<Collider>();
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		   game = new DrawImageOnCanvas();
	}
}
