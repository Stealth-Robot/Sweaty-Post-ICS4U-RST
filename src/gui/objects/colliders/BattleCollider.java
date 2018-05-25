package gui.objects.colliders;

import gui.Vector2;

public class BattleCollider extends InteractiveCollider {
	private double battleChance;
	private double battleTime;
	public BattleCollider(int length, int width, Vector2 position, double battleChance, double battleTime) {
		super(length, width, position);
		this.battleChance = battleChance;
		// TODO Auto-generated constructor stub
	}
	private double currentTime = 0;
	private double scaleTime = 0;
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
	private void generateBattle() {
		
	}
}
