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
	protected int identifier;
	public Scene(int identifier) {
		environment = new ArrayList<ImageData>();
		this.identifier = identifier;
		this.createEnvironment();
	}
	public void initialize() {
		
		sceneColliders = new ArrayList<Rectangle>();
		
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
}
