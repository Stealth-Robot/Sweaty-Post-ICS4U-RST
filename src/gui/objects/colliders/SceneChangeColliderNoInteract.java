package gui.objects.colliders;

import backend.player.Player;
import gui.Vector2;
import gui.VectorCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider.Collisions;
import gui.scenes.Scene;
import main.Main;

public class SceneChangeColliderNoInteract extends InteractiveCollider {
	private Scene scene;
	private Vector2 position;
	private Player.Movement direction;
	private Player.Movement enterDirection;

	public SceneChangeColliderNoInteract(int length, int width, Vector2 position, Scene scene) {
		super(length, width, position);
		this.scene = scene;
	}

	public SceneChangeColliderNoInteract(Rectangle rectangle, Scene scene) {
		super(rectangle);
		this.scene = scene;
	}

	public SceneChangeColliderNoInteract(Rectangle rectangle, Scene scene, Vector2 position,
			Player.Movement direction) {
		super(rectangle);
		this.scene = scene;
		this.position = new Vector2(position.x, position.y);
		this.direction = direction;
	}

	public SceneChangeColliderNoInteract(Rectangle rectangle, Scene scene, Vector2 position, Player.Movement direction,
			Player.Movement enterDirection) {
		super(rectangle);
		this.scene = scene;
		this.position = new Vector2(position.x, position.y);
		this.direction = direction;
		this.enterDirection = enterDirection;
	}

	@Override
	public void onCollision(Collider collision, Collisions direction) {
		if (enterDirection != null) {
			if (Main.game.player.facingDir == enterDirection) {
				scene.initialize();
				if (position != null) {
					Main.game.player.setPosition(VectorCreator.dimensionalVector2(position.x, position.y));
					Main.game.player.facingDir = this.direction;
					Main.game.currentOrientation = this.direction;

				}
			}
		} else {
			scene.initialize();
			if (position != null) {
				Main.game.player.setPosition(VectorCreator.dimensionalVector2(position.x, position.y));
				Main.game.player.facingDir = this.direction;
				Main.game.currentOrientation = this.direction;

			}
		}
	}

}
