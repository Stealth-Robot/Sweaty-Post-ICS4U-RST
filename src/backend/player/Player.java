package backend.player;

import backend.input.Interact;
import gui.Display;
import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import main.Main;

public class Player extends Collider {
	
	public Vector2 position;
	public static final double SPEED = 1;
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
	private Movement move(double xAxis, double yAxis) {
		if(xAxis == 0) {
			if(yAxis < 0)
				return Movement.SOUTH;
			if(yAxis > 0)
				return Movement.NORTH;
		}
		if(yAxis == 0) {
			if(xAxis > 0)
				return Movement.EAST;
			if(xAxis < 0)
				return Movement.WEST;
		}
		if(xAxis > 0 && yAxis < 0) {
			return Movement.SOUTH_EAST;
		}
		else if(xAxis > 0 && yAxis > 0) {
			return Movement.NORTH_EAST;
		}
		else if(xAxis < 0 && yAxis > 0) {
			return Movement.NORTH_WEST;
		}
		else if(xAxis < 0 && yAxis < 0) {
			return Movement.SOUTH_WEST;
		}
		
		return Movement.NONE;
	}
	public Movement facingDir;
	public boolean interacting = false;
	public Movement updateCharacter(double xAxis, double yAxis) {
	
		interacting = Interact.interacted();
		//System.out.println(xAxis);
		double magnitude = Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2));
		if(xAxis == 0 && yAxis == 0) {
			magnitude = 1;
		}
		magnitude /= SPEED;
		position.x += xAxis / magnitude;
		position.y += yAxis / magnitude;
		if(position.x < 0 || position.x > Display.SCREEN_WIDTH - Display.PIXEL_IMAGE_SIZE) {
			position.x -= xAxis / magnitude;
		}
		if(position.y < 0 || position.y > Display.SCREEN_HEIGHT - Display.PIXEL_IMAGE_SIZE) {
			position.y -= yAxis / magnitude;
		}
		Movement m = move(xAxis, yAxis);
		for(Rectangle c : DrawImageOnCanvas.currentScene.sceneColliders) {
			Collider.Collisions cc = c.collision(this, m);
		//	System.out.println(cc);
			if(cc != Collider.Collisions.NONE && cc != Collider.Collisions.ANY) {
				if(cc == Collider.Collisions.NORTH) {
					position.y -= yAxis / magnitude;
				}
				else if(cc == Collider.Collisions.NORTH_EAST) {
					position.y -= yAxis / magnitude;
					position.x -= xAxis / magnitude;
				}
				else if(cc == Collider.Collisions.EAST) {
					position.x -= xAxis / magnitude;
				}
				else if(cc == Collider.Collisions.SOUTH_EAST) {
					position.y -= yAxis / magnitude;
					position.x -= xAxis / magnitude;
				}
				else if(cc == Collider.Collisions.SOUTH) {
					position.y -= yAxis / magnitude;
				}
				else if(cc == Collider.Collisions.SOUTH_WEST) {
					position.y -= yAxis / magnitude;
					position.x -= xAxis / magnitude;
				}
				else if(cc == Collider.Collisions.WEST) {
					position.x -= xAxis / magnitude;
				}
				else if(cc == Collider.Collisions.NORTH_WEST) {
					position.y -= yAxis / magnitude;
					position.x -= xAxis / magnitude;
				}
			}
		}
		return m;
	}
}
