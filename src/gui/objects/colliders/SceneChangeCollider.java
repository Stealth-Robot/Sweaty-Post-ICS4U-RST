package gui.objects.colliders;

import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.objects.Rectangle;
import gui.scenes.Scene;

public class SceneChangeCollider extends InteractableCollider {
	private Scene scene;
	public SceneChangeCollider(int length, int width, Vector2 position, Scene scene) {
		super(length, width, position);
		this.scene = scene;
	}
	public SceneChangeCollider(Rectangle rectangle, Scene scene) {
		super(rectangle);
		this.scene = scene;
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		scene.initialize();
	}

}
