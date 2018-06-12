package gui.objects.colliders;

import backend.player.Player;
import gui.Vector2;
import gui.VectorCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider.Collisions;
import gui.scenes.Scene;
import main.Gunfight;

public class SceneChangeColliderNoInteract extends InteractiveCollider {
	private Scene scene;
	private Vector2 position;
	private Player.Movement direction;
	public SceneChangeColliderNoInteract(int length, int width, Vector2 position, Scene scene) {
		super(length, width, position);
		this.scene = scene;
	}
	public SceneChangeColliderNoInteract(Rectangle rectangle, Scene scene) {
		super(rectangle);
		this.scene = scene;
	}
	public SceneChangeColliderNoInteract(Rectangle rectangle, Scene scene, Vector2 position, Player.Movement direction) {
		super(rectangle);
		this.scene = scene;
		this.position = new Vector2(position.x, position.y);
		this.direction = direction;
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		scene.initialize();
		if(position != null) {
			Gunfight.game.player.setPosition(VectorCreator.dimensionalVector2(position.x, position.y));
			Gunfight.game.player.facingDir = this.direction;
			Gunfight.game.currentOrientation = this.direction;
		}
	}

}
