/*
 * Collider.java
 * base collider for all other colliders to extend
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import gui.Vector2;
import gui.objects.Rectangle;

public class Collider extends Rectangle implements CollisionInteraction {

	public Collider(int length, int width, Vector2 position) {
		super(length, width, position);
		// TODO Auto-generated constructor stub
	}
	public Collider(Rectangle rectangle) {
		super(rectangle);
	}
	public enum Collisions {
		NONE, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST, ANY;
	}

	@Override
	public void onCollision(Collider collision, Collisions direction) {
		System.out.println("Collided");
	}

}
