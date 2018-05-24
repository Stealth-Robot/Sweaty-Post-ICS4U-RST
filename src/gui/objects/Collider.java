package gui.objects;

import backend.player.Player;
import gui.Vector2;

public class Collider extends Rectangle {

	public Collider(int length, int width, Vector2 position) {
		super(length, width, position);
		// TODO Auto-generated constructor stub
	}

	public enum Collisions {
		NONE, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;
	}

	public Collisions collision(Collider player, Player.Movement direction) {
		if (direction == Player.Movement.NONE) {
			return Collisions.NONE;
		}
		if (direction == Player.Movement.NORTH) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y + player.getWidth()))) {
				return Collisions.NORTH;
			}
		}
		if (direction == Player.Movement.NORTH_EAST) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y))) {
				return Collisions.NORTH_EAST;
			}
		}
		if (direction == Player.Movement.EAST) {
			if (getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y))) {
				return Collisions.EAST;
			}
		}
		if (direction == Player.Movement.SOUTH_EAST) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y))) {
				return Collisions.SOUTH_EAST;
			}
		}
		if (direction == Player.Movement.SOUTH) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y))) {
				return Collisions.SOUTH;
			}
		}
		if (direction == Player.Movement.SOUTH_WEST) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x,
							player.getPosition().y))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y))) {
				return Collisions.SOUTH_WEST;
			}
		}
		if (direction == Player.Movement.WEST) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					|| getInside(new Vector2(player.getPosition().x,
							player.getPosition().y + player.getWidth()))) {
				return Collisions.WEST;
			}
		}
		if (direction == Player.Movement.NORTH_WEST) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x,
							player.getPosition().y))) {
				return Collisions.NORTH_WEST;
			}
		}
		return Collisions.NONE;
	}

}
