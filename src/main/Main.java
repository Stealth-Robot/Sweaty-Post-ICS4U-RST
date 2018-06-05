package main;

import java.util.ArrayList;

import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.objects.Rectangle;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
//update
public class Main {
	public static ArrayList<Rectangle> sceneColliders = new ArrayList<Rectangle>();
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		   game = new DrawImageOnCanvas();
		   sceneColliders.add(RectangleCreator.createDimensionalRectangle(1,1,2,2));
	}
}
