package gui.scenes;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.DrawImageOnCanvas;
import gui.objects.Rectangle;
import images.ImageData;

public abstract class Scene implements IScene {
	public ArrayList<ImageData> environment;
	public ArrayList<Rectangle> sceneColliders;
	public Scene(int identifier) {
	}
	public void initialize() {
		environment = new ArrayList<ImageData>();
		sceneColliders = new ArrayList<Rectangle>();
		this.createEnvironment();
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
