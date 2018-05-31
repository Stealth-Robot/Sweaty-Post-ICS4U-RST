package gui.objects.colliders;

import gui.Vector2;
import gui.scenes.Scene;

public class SceneChangeCollider extends InteractiveCollider {
	private Scene scene;
	public SceneChangeCollider(int length, int width, Vector2 position, Scene scene) {
		super(length, width, position);
		this.scene = scene;
	}

	@Override
	public void onCollision(Collider collision, Collisions direction) {
		//scene.instantiate();
	}

}
