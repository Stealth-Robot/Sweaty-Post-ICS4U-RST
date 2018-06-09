package gui.objects.colliders;

import backend.input.Interact;
import backend.player.Player;
import gui.Display;
import gui.Vector2;
import gui.objects.Rectangle;
import main.Main;

abstract class InteractableCollider extends InteractiveCollider {
	public InteractableCollider(int length, int width, Vector2 position) {
		super(length, width, position);
	}
	public InteractableCollider(Rectangle rectangle) {
		super(rectangle);
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
	}
	@Override
	public Collisions collision(Collider player, Player.Movement direction) {
		Collisions c = Collisions.NONE;
		if(Main.game.player.interacting && interacted(player,direction)) {
			c = super.collision(player, direction);
		}
		return c;
	}
	public Player.Movement temp = Player.Movement.NONE;
	public boolean interacted(Collider player, Player.Movement direction) {
		direction = Main.game.player.facingDir;
		if(direction != Player.Movement.NONE) {
			temp = direction;
			if (direction == Player.Movement.NORTH_EAST || direction == Player.Movement.NORTH_WEST) temp = Player.Movement.NORTH;
			if (direction == Player.Movement.SOUTH_EAST || direction == Player.Movement.SOUTH_WEST) temp = Player.Movement.SOUTH;
		}
		if (player.getPosition().y < super.getPosition().y)
			if (Player.Movement.NORTH == temp) return true;
		if (player.getPosition().y > super.getPosition().y)
			if (Player.Movement.SOUTH == temp) return true;
		if (player.getPosition().x < super.getPosition().x)
			if (Player.Movement.EAST == temp) return true;
		if (player.getPosition().x > super.getPosition().x)
			if (Player.Movement.WEST == temp) return true;

		return false;
	}
}
