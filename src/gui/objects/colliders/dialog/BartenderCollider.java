package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import main.Main;

public class BartenderCollider extends SpeechCollider {

	public BartenderCollider(Rectangle rectangle) {
		super(rectangle);
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		int i;
		do {
			i = DialogCreator.createDialog("Bartender","Hi, wazzup fam",null,"How drunk am I?","give me more drincc","Exit");
			if(i == 0) {
				DialogCreator.createDialog("Bartender", "You are " + Main.game.player.drunkness + " drunk.",null, "Ok");
			}
			if(i == 1) {
				Main.game.player.drunkness++;
				DialogCreator.createDialog("Bartender", "Have a nice sipp",null, "Ok");
			}
		} while(i != 2 && i != -1);
	}
}
