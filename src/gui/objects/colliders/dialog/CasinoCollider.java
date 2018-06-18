package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class CasinoCollider extends SpeechCollider {

	public CasinoCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	/**
	 * pre: onCollision
	 * post: is overridden
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
				DialogCreator.createDialog("Casino Manager","Welcome to the casino! Play games for fun, or play rock paper scissors to win/lose damsels! Fun for the whole family if you're good at the games...",null,"K thanks");
		}
}
