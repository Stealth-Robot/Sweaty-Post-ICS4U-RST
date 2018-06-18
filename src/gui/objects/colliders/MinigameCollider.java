/*
 * MinigameCollider.java
 * sets up colliders that call the minigames
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.objects.colliders;

import gui.objects.Minigame;
import gui.objects.Rectangle;
import minigames.WildWest;

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
