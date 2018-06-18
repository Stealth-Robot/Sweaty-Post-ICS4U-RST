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
	//Information related to the player object
	public Vector2 position;
	public static final double SPEED = 2;
	public int drunkness = 0;
	public int damsels = 1;
	//An enumeration used to display the direction the player is moving
	public enum Movement {
		NONE, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;
	}
	/**
	 * Pre: Gets a string
	 * During: Messes up the string based on the drunkeness of the player
	 * Post: Returns the messed up string
	 * @param string
	 * @return
	 */
	public String say(String string) {
		char[] newSentence = new char[string.toCharArray().length];
		for(int i = 0; i < string.toCharArray().length; i++) {
			if(Math.random() * 100.0 < drunkness) {
				newSentence[i] = (char)(new Random().nextInt(26) + 'a');
			}
			else {
				newSentence[i] = string.toCharArray()[i];
			}
		}
		String s = new String(newSentence);
		//System.out.println(s);
		return s;
	}
	
	/**
	 * Pre: Gets a string
	 * During: Messes up the string based on the drunkeness of the player
	 * Post: Returns the messed up string
	 * @param words
	 * @return
	 */
	public String[] say(String string[]) {
		for(int q = 0; q < string.length; q++) {
		char[] newSentence = new char[string[q].toCharArray().length];
		for(int i = 0; i < string[q].toCharArray().length; i++) {
			if(Math.random() * 50 < drunkness) {
				newSentence[i] = (char)(new Random().nextInt(26) + 'a');
			}
			else {
				newSentence[i] = string[q].toCharArray()[i];
			}
		}
		String s = new String(newSentence);
		string[q] = s;
		//System.out.println(s);
		}
		return string;
	}
	/* Constructor for the player object
	 * 
	 * Pre: When created
	 * During: Assign variables:
	 * Post: N/A
	 */
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
	
	//Everything below is used for the drunkness in the game
	int tickCounter = 0;
	int ticks = 100;
	int i = 0;
	int decay = 5000;
	int currentMovement = 0;
	public Movement facingDir;
	public boolean interacting = false;
	
	/**
	 * Pre: Called once per tick
	 * During: 	Updates the player's x/y coordinates based on the inputs getting pressed
	 * 			Also decays the drunkeness value every tick
	 * Post: Updates the x and y values
	 * @param xAxis
	 * @param yAxis
	 * @return
	 */
	public Movement updateCharacter(double xAxis, double yAxis) {
		if(drunkness > 0) {
			i++;
		}
		if(i > decay) {
			i = 0;
			if(drunkness > 0) {
				System.out.println("Drunk decay");
				drunkness--;
			}
		}
		//If you are suffienctly drunk
		if(drunkness >= 20) {
			tickCounter++;
			if(tickCounter > ticks) {
				currentMovement = ThreadLocalRandom.current().nextInt(0, 3 + 1);
				tickCounter = 0;
			}
			//Fuck up all of the shit
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
		//Less fucking up of the shit
		else if(drunkness >= 15) {
			double temp = xAxis;
			xAxis = -yAxis;
			yAxis = -temp;
		}
		//Even less fucking up of the shit
		else if(drunkness >= 10) {
			double temp = xAxis;
			xAxis = yAxis;
			yAxis = temp;
		}
		//Not very much fucking up of the shit
		else if(drunkness >= 5) {
			xAxis = -xAxis;
			yAxis = -yAxis;
	}
	
	//Get the interacted boolean
		interacting = Interact.interacted();
		//Get the magnitude of the speed in the x/y direction (1 if moving in a straight line)
		double magnitude = Math.sqrt(Math.pow(xAxis, 2) + Math.pow(yAxis, 2));
		if(xAxis == 0 && yAxis == 0) {
			magnitude = 1;
		}
	
		//Move the player
		magnitude /= SPEED;
		position.x += xAxis / magnitude;
		position.y += yAxis / magnitude;
		
		if(position.x < 0 || position.x > Display.SCREEN_WIDTH - Display.PIXEL_IMAGE_SIZE + 1) {
			position.x -= xAxis / magnitude;
		}
		if(position.y < 0 || position.y > Display.SCREEN_HEIGHT - Display.PIXEL_IMAGE_SIZE + 1) {
			position.y -= yAxis / magnitude;
		}
		//Move the player if there are no collision
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
