package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class BankCollider extends SpeechCollider {

	public BankCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	/**
	 * pre: onCollision
	 * post: overrides action
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		int i;
		do {
			i = DialogCreator.createDialog("Banker","Sup my dude",null,"How Many Damsels do I have?","Exit");
			if(i == 0) {
				DialogCreator.createDialog("Banker", "You have " + Main.game.player.damsels + " damsels.",null, "Thats pretty cool");
			}
		} while(i != 1 && i != -1);
	}
}
