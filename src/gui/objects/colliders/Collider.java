package gui.objects.colliders;

import gui.Vector2;
import gui.objects.Rectangle;

public class Collider extends Rectangle implements CollisionInteraction {

	public Collider(int length, int width, Vector2 position) {
		super(length, width, position);
		// TODO Auto-generated constructor stub
	}

	public enum Collisions {
		NONE, NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;
	}

	@Override
	public void onCollision(Collider collision, Collisions direction) {
		System.out.println("Collided");
	}

}
