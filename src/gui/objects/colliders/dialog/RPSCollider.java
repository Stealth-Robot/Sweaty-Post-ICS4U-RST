/*
 * RPSCollider.java
 * plays a game of RPS
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders.dialog;

import java.util.concurrent.ThreadLocalRandom;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class RPSCollider extends SpeechCollider {

	/**
	 * pre: none
	 * post: is constructed
	 */
	public RPSCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	/**
	 * pre: onCollision
	 * post: is overridden
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		int i;
		do {
			if(Main.game.player.damsels == 0) {
				DialogCreator.createDialog("Casino Guy 3","You have no damsels im not playing with you",null,":(");
				break;
			}
			i = DialogCreator.createDialog("Casino Guy 3","WE ARE PLAYING ROCK PAPER SCISSORS what do u pick (if i win i get a damsel if u win u get a damsel)",null,"Rock","Paper","Scissors","Exit");
			int otherRoll = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			i++;
			if(i == 0 || i == 4) {
				break;
			}
			String played = otherRoll == 1 ? "Rock" : (otherRoll == 2 ? "Paper" : "Scissors");
			if(otherRoll == i) {
				DialogCreator.createDialog("Casino Guy 3","I played " + played + ", We tied lmao",null,"Ok");
			}
			else if((otherRoll == 1 && i == 3) || (otherRoll == 2 && i == 1) || (otherRoll == 3 && i == 2)) {
				DialogCreator.createDialog("Casino Guy 3","I played " + played + ", GGEZ I win",null,"Ok");
				Main.game.player.damsels--;
			}
			else {
				DialogCreator.createDialog("Casino Guy 3","I played " + played + ", RIP I lost",null,"Ok");
				Main.game.player.damsels++;
			}
		} while(i != 4 && i != 0);
	}
}
