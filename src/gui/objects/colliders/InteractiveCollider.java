package gui.objects.colliders;

import backend.player.Player;
import gui.Vector2;

public abstract class InteractiveCollider extends Collider implements CollisionInteraction {

	public InteractiveCollider(int length, int width, Vector2 position) {
		super(length, width, position);
	}
	public Collisions collision(Collider player, Player.Movement direction) {
		Collisions c = super.collision(player, direction);
		if(!c.equals(Collisions.NONE)) {
			onCollision(player,c);
		}
		return c;
	}
}
