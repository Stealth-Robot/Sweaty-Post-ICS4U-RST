/*
 * BattleCollider.java
 * starts a batte when collided
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import PresentationClasses.Villain;
import gui.Vector2;
import gui.objects.Rectangle;
import minigames.WildWest;

public class BattleCollider extends InteractiveCollider {
	public Villain villain;
	
	public BattleCollider(Rectangle r, Villain villain) {
		super(r);
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