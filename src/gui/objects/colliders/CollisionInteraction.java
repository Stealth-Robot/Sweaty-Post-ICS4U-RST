/*
 * CollisionInteraction.java
 * interface for the colliders
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

public interface CollisionInteraction {

	public void onCollision(Collider collision, Collider.Collisions direction);
}
