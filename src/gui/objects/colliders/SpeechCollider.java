/*
 * Speech Collider.java
 * sets up a collider for use with inter-character speech
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import gui.objects.Rectangle;

public abstract class SpeechCollider extends InteractableColliderNoConstraint implements CollisionInteraction {

	public SpeechCollider(Rectangle rectangle) {
		super(rectangle);
	}
}
