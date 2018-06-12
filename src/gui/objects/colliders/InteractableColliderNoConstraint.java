package gui.objects.colliders;

import backend.input.Interact;
import backend.player.Player;
import gui.Display;
import gui.Vector2;
import gui.objects.Rectangle;
import main.Main;

abstract class InteractableColliderNoConstraint extends InteractiveCollider {
	public InteractableColliderNoConstraint(int length, int width, Vector2 position) {
		super(length, width, position);
	}
	public InteractableColliderNoConstraint(Rectangle rectangle) {
		super(rectangle);
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
	}
	@Override
	public Collisions collision(Collider player, Player.Movement direction) {
		Collisions c = Collisions.NONE;
		if(Main.game.player.interacting) {
			c = super.collision(player, direction);
		}
		return c;
	}
}
