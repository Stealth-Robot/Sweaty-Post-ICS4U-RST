package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class RPSCollider extends SpeechCollider {

	public RPSCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		int i;
		do {
			i = DialogCreator.createDialog("Casino Guy","WE ARE PLAYING ROCK PAPER SCISSORS what do u pick",null,"Rock","Paper","Scissors","Exit");
	//		int otherRoll =
			if(i == 0) {
				DialogCreator.createDialog("Bartender", "You are " + Main.game.player.drunkness + " drunk.",null, "Ok");
			}
			if(i == 1) {
				Main.game.player.drunkness++;
				DialogCreator.createDialog("Bartender", "Have a nice sipp",null, "Ok");
			}
		} while(i != 3 && i != -1);
	}
}
