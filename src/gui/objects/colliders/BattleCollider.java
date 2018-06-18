/*
 * BattleCollider.java
 * starts a batte when collided
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import PresentationClasses.Villain;
import gui.Vector2;
import wildWest.WildWest;

public class BattleCollider extends InteractiveCollider {
	public Villain villain;
	
	public BattleCollider(int length, int width, Vector2 position, Villain villain) {
		super(length, width, position);
		this.villain = villain;
	}
	
boolean first = true;
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		if(first) {
			first = false;
			new WildWest(villain);
		}
	}
}