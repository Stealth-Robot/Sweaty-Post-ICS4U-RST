package backend.player;

import gui.Vector2;
import gui.objects.Collider;
import main.Main;

public class Player extends Collider {
	
	public Vector2 position;
	public static final double SPEED = 1.0;
	public enum Movement {
		NONE, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;
	}
	
	public Player(int length, int width, Vector2 position) {
		super(length,width,position);
		this.position = position;
	}
	/**
	 * Player movement, 0 = no movement on axis
	 * @param xAxis -1 for left, 1 for right
	 * @param yAxis -1 for down, 1 for up
	 */
	private Movement move(int xAxis, int yAxis) {
		if(xAxis == 0) {
			if(yAxis > 0)
				return Movement.NORTH;
			if(yAxis < 0)
				return Movement.SOUTH;
		}
		if(yAxis == 0) {
			if(xAxis > 0)
				return Movement.EAST;
			if(xAxis < 0)
				return Movement.WEST;
		}
		if(xAxis > 0 && yAxis > 0) {
			return Movement.NORTH_EAST;
		}
		else if(xAxis > 0 && yAxis < 0) {
			return Movement.SOUTH_EAST;
		}
		else if(xAxis < 0 && yAxis < 0) {
			return Movement.SOUTH_WEST;
		}
		else if(xAxis < 0 && yAxis > 0) {
			return Movement.NORTH_WEST;
		}
		
		return Movement.NONE;
	}
	public void updateCharacter(int xAxis, int yAxis) {
		double magnitude = Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2));
		position.x += xAxis / magnitude;
		position.y += yAxis / magnitude;
		Movement m = move(xAxis, yAxis);
		for(Collider c : Main.sceneColliders) {
			if(c.collision(this, m) != Collider.Collisions.NONE) {
				// oh shit cant move there
			}
		}
		// call gui.update with players new position
	}
}
