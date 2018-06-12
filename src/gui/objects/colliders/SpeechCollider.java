package gui.objects.colliders;

import dialog.DialogCreator;
import gui.objects.Rectangle;

public class SpeechCollider extends InteractableColliderNoConstraint {
	public String title;
	public String text;
	public SpeechCollider(Rectangle rectangle, String title, String text) {
		super(rectangle);
		this.title = title;
		this.text = text;
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		DialogCreator.createDialog(title, text);
	}
	
}
