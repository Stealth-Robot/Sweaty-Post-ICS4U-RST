/*
 * Scene.java
 * sets up the default scene all called scenes extend
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.DrawImageOnCanvas;
import gui.objects.Rectangle;
import images.ImageData;

public abstract class Scene implements IScene {
	public ArrayList<ImageData> environment;
	public ArrayList<Rectangle> sceneColliders;
	public ArrayList<Rectangle> battleColliders;
	protected int identifier;
	public Scene(int identifier) {
		environment = new ArrayList<ImageData>();
		battleColliders = new ArrayList<Rectangle>();
		this.identifier = identifier;
		this.createEnvironment();
		this.createBattleColliders();
	}
	public void initialize() {
		
		sceneColliders = new ArrayList<Rectangle>();
		sceneColliders.addAll(battleColliders);
		this.createColliders();
		DrawImageOnCanvas.currentScene = this;
	}
	public void render(Graphics g) {
		for(ImageData i : environment) {
			g.drawImage(i.getImage(),i.getxPos(), i.getyPos(), null);
		}
	}
	public void add(ImageData i) {
		environment.add(i);
	}
	public void addCollider(Rectangle r) {
		sceneColliders.add(r);
	}
	public void addBattleCollider(Rectangle r) {
		battleColliders.add(r);
	}
}
