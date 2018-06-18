package gui.objects.colliders.dialog;

import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class JailCollider extends SpeechCollider {

	public JailCollider(Rectangle rectangle) {
		super(rectangle);
		// TODO Auto-generated constructor stub
	}
	/**
	 * pre: onCollision
	 * post: overrides action
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		String enemies = "";
		for(int i = 0; i < Main.enemies.length; i++) {
			enemies += "\n" + Main.enemies[i].name + ": " + (Main.enemies[i].ready ? "In Town" : "Not in Town");
		}
		DialogCreator.createDialog("Jailer","Sup ma bro, these are the people in this wild west town: " + enemies,null,"ok fam");
	}
}
