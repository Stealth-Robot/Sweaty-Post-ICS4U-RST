package main;

import java.util.ArrayList;

import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.objects.Rectangle;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeCollider;
import gui.scenes.locations.SceneMaster;
import wildWest.WildWest;

import java.lang.Math;
//update
public class Main {
	
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		game = new DrawImageOnCanvas();
		//sceneColliders.add(RectangleCreator.createDimensionalRectangle(1,1,2,2));
		new WildWest();
	}
}