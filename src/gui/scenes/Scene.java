package gui.scenes;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.objects.Rectangle;
import images.ImageData;

public abstract class Scene implements IScene {
	public ArrayList<ImageData> environment = new ArrayList<ImageData>();
	public ArrayList<Rectangle> sceneColliders = new ArrayList<Rectangle>();
	public Scene() {
		this.createEnvironment();
		this.createColliders();
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
