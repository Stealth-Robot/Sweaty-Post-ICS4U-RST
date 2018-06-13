package gui.objects.colliders;

import gui.objects.Rectangle;

public abstract class SpeechCollider extends InteractableColliderNoConstraint implements CollisionInteraction {

	public SpeechCollider(Rectangle rectangle) {
		super(rectangle);
	}
}
