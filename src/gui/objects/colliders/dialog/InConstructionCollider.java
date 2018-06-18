package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class InConstructionCollider extends SpeechCollider {

	public InConstructionCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCollision(Collider collision, Collisions direction) {
		DialogCreator.createDialog("Casino Boiyoo", "This game is in construction... :(", null, "Ok");
	}
}
