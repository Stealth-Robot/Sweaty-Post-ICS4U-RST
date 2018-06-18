/*
 * BattleAI.java
 * the AI for the wild west game
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package backend.battle;

public class BattleAI {
	/**
	 * pre: none
	 * post: ai chooses action
	 */
	public static int choice(BattleCharacter player, BattleCharacter enemy) {
		//Adds weight to the shooting action
		int shoot = 0;
		//Weights the shooting option more if there are more bullets
		for(int i = 0; i < enemy.bullets; i++) {
			if(Math.random() < 0.5) {
				shoot++;
			}
		}
		//Adds weight to the blocking option
		int block = 0;
		//Weights the blocking option more if there are more player bullets
		for(int i = 0; i < player.bullets; i++) {
			if(Math.random() < 0.5) {
				block++;
			}
		}
		//if there is a higher shooting chance than zero and there is more shooting than block
		if(shoot > 0 && shoot > block) {
			return 1;
		}
		//If block has a higher outcome
		else if(block > 0 && block > shoot) {
			return 3;
		}
		//If they are equal and above then choose randomly
		else if(shoot > 0 && block > 0) {
			return Math.random() < 0.5 ? 1 : 3;
		}
		
		//Otherwise reload
		return 2;
	}
}
