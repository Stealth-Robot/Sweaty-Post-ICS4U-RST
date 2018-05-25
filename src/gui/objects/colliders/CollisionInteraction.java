package gui.objects.colliders;

public interface CollisionInteraction {

	public void onCollision(Collider collision, Collider.Collisions direction);
}
