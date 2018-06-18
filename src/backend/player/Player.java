/*
 * Player.java
 * sets up the player instantiation and constructor and regulates movement
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package backend.player;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import backend.input.Interact;
import gui.Display;
import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import main.Main;

public class Player extends Collider {
	
	public Vector2 position;
	public static final double SPEED = 2;
	public int drunkness = 0;
	public int damsels = 1;
	public enum Movement {
		NONE, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;
	}
	public String say(String words) {
		char[] newSentence = new char[words.toCharArray().length];
		for(int i = 0; i < words.toCharArray().length; i++) {
			if(Math.random() * 100.0 < drunkness) {
				newSentence[i] = (char)(new Random().nextInt(26) + 'a');
			}
			else {
				newSentence[i] = words.toCharArray()[i];
			}
		}
		String s = new String(newSentence);
		//System.out.println(s);
		return s;
	}
	public String[] say(String words[]) {
		for(int q = 0; q < words.length; q++) {
		char[] newSentence = new char[words[q].toCharArray().length];
		for(int i = 0; i < words[q].toCharArray().length; i++) {
			if(Math.random() * 100.0 < drunkness) {
				newSentence[i] = (char)(new Random().nextInt(26) + 'a');
			}
			else {
				newSentence[i] = words[q].toCharArray()[i];
			}
		}
		String s = new String(newSentence);
		words[q] = s;
		//System.out.println(s);
		}
		return words;
	}
	public Player(int length, int width, Vector2 position) {
		super(length,width,position);
		this.position = position;
	}
	/**
	 * pre: none
	 * post: Player movement, 0 = no movement on axis
	 *  xAxis -1 for left, 1 for right
	 *  yAxis -1 for down, 1 for up
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
	int tickCounter = 0;
	int ticks = 100;
	int i = 0;
	int decay = 1000;
	int currentMovement = 0;
	public Movement facingDir;
	public boolean interacting = false;
	public Movement updateCharacter(double xAxis, double yAxis) {
		i++;
		if(i > decay) {
			i = 0;
			drunkness--;
		}
		if(drunkness >= 100) {
			tickCounter++;
			if(tickCounter > ticks) {
				currentMovement = ThreadLocalRandom.current().nextInt(0, 3 + 1);
				tickCounter = 0;
			}
			switch(currentMovement) {
			case 0:
				break;
			case 1:
				xAxis = -xAxis;
				yAxis = -yAxis;
				break;
			case 2:
				double temp = xAxis;
				xAxis = yAxis;
				yAxis = temp;
				break;
			case 3:
				double temp2 = xAxis;
				xAxis = -yAxis;
				yAxis = -temp2;
				break;
			}
		}
		else if(drunkness >= 75) {
			double temp = xAxis;
			xAxis = -yAxis;
			yAxis = -temp;
		}
		else if(drunkness >= 50) {
			double temp = xAxis;
			xAxis = yAxis;
			yAxis = temp;
		}
		else if(drunkness >= 25) {
			xAxis = -xAxis;
			yAxis = -yAxis;
	}
	
	
		
		interacting = Interact.interacted();
		double magnitude = Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2));
		if(xAxis == 0 && yAxis == 0) {
			magnitude = 1;
		}
	
		magnitude /= SPEED;
		position.x += xAxis / magnitude;
		position.y += yAxis / magnitude;
		
		if(position.x < 0 || position.x > Display.SCREEN_WIDTH - Display.PIXEL_IMAGE_SIZE + 1) {
			position.x -= xAxis / magnitude;
		}
		if(position.y < 0 || position.y > Display.SCREEN_HEIGHT - Display.PIXEL_IMAGE_SIZE + 1) {
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
