package main;

import java.util.ArrayList;

import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.objects.Rectangle;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
<<<<<<< HEAD
import wildWest.WildWest;

import java.lang.Math;
=======
>>>>>>> 6058bc87bcd642ce36fe0313a54093a419dc4893
//update
public class Main {
	public static ArrayList<Rectangle> sceneColliders = new ArrayList<Rectangle>();
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
<<<<<<< HEAD
		game = new DrawImageOnCanvas();
		new WildWest();
=======
		   game = new DrawImageOnCanvas();
		   sceneColliders.add(RectangleCreator.createDimensionalRectangle(1,1,2,2));
>>>>>>> 6058bc87bcd642ce36fe0313a54093a419dc4893
	}
}
