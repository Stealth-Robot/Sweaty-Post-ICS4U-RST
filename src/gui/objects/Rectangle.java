package gui.objects;

import backend.player.Player;
import gui.Vector2;
import gui.objects.colliders.Collider;
import gui.objects.colliders.Collider.Collisions;

public class Rectangle {

	private int length;
	private int width;
	private Vector2 position;

	public Rectangle(int length, int width, Vector2 position) {
		this.length = length;
		this.width = width;
		this.position = position;
	}
	public Rectangle(Rectangle rectangle) {
		this.length = rectangle.getLength();
		this.width = rectangle.getWidth();
		this.position = rectangle.getPosition();
	}
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position.x = position.x;
		this.position.y = position.y;
	}

	public boolean getInside(Vector2 playerPos) {
		return playerPos.x >= position.x && playerPos.x <= position.x + length && playerPos.y >= position.y
				&& playerPos.y <= position.y + width;
	}

	public Collisions collision(Collider player, Player.Movement direction) {
		if (direction == Player.Movement.NORTH) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y + player.getWidth()))) {
				return Collisions.NORTH;
			}
		}
		if (direction == Player.Movement.EAST) {
			if (getInside(new Vector2(player.getPosition().x + player.getLength(),
					player.getPosition().y + player.getWidth()))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))) {
				return Collisions.EAST;
			}
		}
		if (direction == Player.Movement.SOUTH) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					|| getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))) {
				return Collisions.SOUTH;
			}
		}
		if (direction == Player.Movement.WEST) {
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					|| getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))) {
				return Collisions.WEST;
			}
		}

		if (direction == Player.Movement.SOUTH_EAST) {
			if (!getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					&& getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))
					&& !getInside(new Vector2(player.getPosition().x + player.getLength(),
							player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x + player.getLength() - 1, player.getPosition().y))
					&& !getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + 1))) {
				return Collisions.SOUTH_EAST;
			}
			if (getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))) {
				if (getInside(new Vector2(player.getPosition().x + player.getLength() - 1, player.getPosition().y))) {
					return Collisions.SOUTH;
				} else {
					return Collisions.EAST;
				}
			}
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))) {
				return Collisions.SOUTH;
			}
			if (getInside(new Vector2(player.getPosition().x + player.getLength(),
					player.getPosition().y + player.getWidth()))) {
				return Collisions.EAST;
			}
		}

		if (direction == Player.Movement.SOUTH_WEST) {
			if (!getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))
					&& getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					&& !getInside(new Vector2(player.getPosition().x,
							player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x + 1, player.getPosition().y))
					&& !getInside(new Vector2(player.getPosition().x, player.getPosition().y + 1))) {
				return Collisions.SOUTH_WEST;
			}
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y))) {
				if (getInside(new Vector2(player.getPosition().x + 1, player.getPosition().y))) {
					return Collisions.SOUTH;
				} else {
					return Collisions.WEST;
				}
			}
			if (getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))) {
				return Collisions.SOUTH;
			}
			if (getInside(new Vector2(player.getPosition().x,
					player.getPosition().y + player.getWidth()))) {
				return Collisions.WEST;
			}
		}

		if (direction == Player.Movement.NORTH_WEST) {
			if (!getInside(new Vector2(player.getPosition().x, player.getPosition().y))
					&& !getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth()))
					&& getInside(new Vector2(player.getPosition().x,
							player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x + 1, player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth() - 1))) {
				return Collisions.NORTH_WEST;
			}
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))) {
				if (getInside(new Vector2(player.getPosition().x + 1, player.getPosition().y + player.getWidth()))) {
					return Collisions.NORTH;
				} else {
					return Collisions.WEST;
				}
			}
			if (getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth()))) {
				return Collisions.NORTH;
			}
			if (getInside(new Vector2(player.getPosition().x,
					player.getPosition().y))) {
				return Collisions.WEST;
			}
		}
		if (direction == Player.Movement.NORTH_EAST) {
			if (!getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))
					&& getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x,
							player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x + player.getLength() - 1, player.getPosition().y + player.getWidth()))
					&& !getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth() - 1))) {
				return Collisions.NORTH_EAST;
			}
			if (getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth()))) {
				if (getInside(new Vector2(player.getPosition().x + player.getLength() - 1, player.getPosition().y + player.getWidth()))) {
					return Collisions.NORTH;
				} else {
					return Collisions.EAST;
				}
			}
			if (getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))) {
				return Collisions.NORTH;
			}
			if (getInside(new Vector2(player.getPosition().x + player.getLength(),
					player.getPosition().y))) {
				return Collisions.EAST;
			}
		}
			if(getInside(new Vector2(player.getPosition().x, player.getPosition().y)) 
					||getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y))
					||getInside(new Vector2(player.getPosition().x, player.getPosition().y + player.getWidth()))
					||getInside(new Vector2(player.getPosition().x + player.getLength(), player.getPosition().y + player.getWidth()))) {
				return Collisions.ANY;
			}
			return Collisions.NONE;
		
	}
}
