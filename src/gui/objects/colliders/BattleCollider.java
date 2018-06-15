/*
 * BattleCollider.java
 * starts a batte when collided
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import gui.Vector2;
import wildWest.WildWest;

public class BattleCollider extends InteractiveCollider {
	private double battleChance;
	private double battleTime;
	public BattleCollider(int length, int width, Vector2 position) {
		super(length, width, position);
		this.battleChance = battleChance;
		// TODO Auto-generated constructor stub
	}
	private double currentTime = 0;
	private double scaleTime = 0;
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		new WildWest();
	}
	private void generateBattle() {
		
	}
}
