package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class HotelCollider extends SpeechCollider {

	public HotelCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	/**
	 * pre: onCollision
	 * post: overrides action
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		DialogCreator.createDialog("Hotel Manager","Hi, this is the hotel. You will respawn here if u die like a loser.",null,"ok fam");
	}
}
