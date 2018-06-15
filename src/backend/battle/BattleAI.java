/*
 * BattleAI.java
 * the AI for the wild west game
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package backend.battle;

public class BattleAI {
	public static int choice(BattleCharacter player, BattleCharacter enemy) {
		System.out.println(player.bullets);
		int shoot = 0;
		for(int i = 0; i < enemy.bullets; i++) {
			if(Math.random() < 0.5) {
				shoot++;
			}
		}
		int block = 0;
		for(int i = 0; i < player.bullets; i++) {
			if(Math.random() < 0.5) {
				block++;
			}
		}
		if(shoot > 0 && shoot > block) {
			return 1;
		}
		else if(block > 0 && block > shoot) {
			return 3;
		}
		else if(shoot > 0 && block > 0) {
			return Math.random() < 0.5 ? 1 : 3;
		}
		return 2;
	}
}
