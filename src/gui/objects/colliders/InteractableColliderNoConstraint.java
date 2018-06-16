/*
 * InteractiveColliderNoConstraint.java
 * sets up a collider that the player dosent need to press a key to use
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import backend.input.Interact;
import backend.player.Player;
import gui.Display;
import gui.Vector2;
import gui.objects.Rectangle;
import main.Main;

abstract class InteractableColliderNoConstraint extends InteractiveCollider {

	/**
	 * pre: none
	 * post: is constructed
	 */
	public InteractableColliderNoConstraint(int length, int width, Vector2 position) {
		super(length, width, position);
	}

	/**
	 * pre: none
	 * post: collider is called
	 */
	public InteractableColliderNoConstraint(Rectangle rectangle) {
		super(rectangle);
	}

	/**
	 * pre: collision
	 * post: action is overridden
	 */
	@Override
	public Collisions collision(Collider player, Player.Movement direction) {
		Collisions c = Collisions.NONE;
		if(Main.game.player.interacting) {
			c = super.collision(player, direction);
		}
		return c;
	}
}
