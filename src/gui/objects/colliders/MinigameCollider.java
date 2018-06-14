package gui.objects.colliders;

import gui.objects.Minigame;
import gui.objects.Rectangle;
import wildWest.WildWest;

public class MinigameCollider extends InteractableCollider {
	private Minigame minigame;
	public MinigameCollider(Rectangle rectangle, Minigame minigame) {
		super(rectangle);
		this.minigame = minigame;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		minigame.start();
	}
}
