/*
 * BattleCollider.java
 * starts a batte when collided
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import gui.Vector2;

public class BattleCollider extends InteractiveCollider {
	private double battleChance;
	private double battleTime;

	/**
	 * pre: none
	 * post: collider is set
	 */
	public BattleCollider(int length, int width, Vector2 position) {
		super(length, width, position);
		this.battleChance = battleChance;
		// TODO Auto-generated constructor stub
	}
	private double currentTime = 0;
	private double scaleTime = 0;

	/**
	 * pre: onCollision
	 * post: action is overridden
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		currentTime += System.currentTimeMillis() - scaleTime;
		if(!direction.equals(Collisions.NONE)) {
			if(currentTime > battleTime) {
				scaleTime = System.currentTimeMillis();
				currentTime = 0;
				if(Math.random() < battleChance) {
					//DO BATTLE
				}
			}
		}
	}
	/**
	 * pre: none
	 * post: battle is generated
	 */
	private void generateBattle() {
		
	}
}
