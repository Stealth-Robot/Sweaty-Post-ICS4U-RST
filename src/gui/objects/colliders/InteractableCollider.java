package gui.objects.colliders;

import backend.input.Interact;
import backend.player.Player;
import gui.Vector2;

abstract class InteractableCollider extends InteractiveCollider {
	public InteractableCollider(int length, int width, Vector2 position, double battleChance, double battleTime) {
		super(length, width, position);
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
	}
	@Override
	public Collisions collision(Collider player, Player.Movement direction) {
		return null;
		
	}
	public boolean Interacted(Player.Movement direction, Player player) {
		Player.Movement temp = direction;
		if (direction == Player.Movement.NORTH_EAST || direction == Player.Movement.NORTH_WEST) temp = Player.Movement.NORTH;
		if (direction == Player.Movement.SOUTH_EAST || direction == Player.Movement.SOUTH_WEST) temp = Player.Movement.SOUTH;


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
