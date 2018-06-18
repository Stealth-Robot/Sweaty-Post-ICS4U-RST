/*
 * BartenderCollider.java
 * sets up dailogue when getting drinks from the bartender
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import main.Main;

public class BartenderCollider extends SpeechCollider {

	/**
	 * pre: none
	 * post: is constructed
	 */
	public BartenderCollider(Rectangle rectangle) {
		super(rectangle);
	}
	/**
	 * pre: onCollision
	 * post: overrides action
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		int i;
		do {
			i = DialogCreator.createDialog("Bartender","Hi, wazzup fam",null,"How drunk am I?","give me more drincc (1 Damsel)","Exit");
			if(i == 0) {
				DialogCreator.createDialog("Bartender", "You are " + Main.game.player.drunkness + " drunk.",null, "Ok");
			}
			if(i == 1) {
				if(Main.game.player.damsels > 0) {
					Main.game.player.drunkness++;
					Main.game.player.damsels--;
					DialogCreator.createDialog("Bartender", "Have a nice sipp",null, "Ok");
				}
				else {
					DialogCreator.createDialog("Bartender", "You have no damsels :(",null, "Oh...");
				}
				
			}
		} while(i != 2 && i != -1);
	}
}
