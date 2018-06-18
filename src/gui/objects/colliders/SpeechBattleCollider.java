package gui.objects.colliders;

import PresentationClasses.Villain;
import dialog.DialogCreator;
import gui.objects.Rectangle;
import wildWest.WildWest;

public class SpeechBattleCollider extends InteractiveCollider {
	public Villain villain;
	public String text;
	public SpeechBattleCollider(Rectangle r, Villain villain,String text) {
		super(r);
		this.villain = villain;
		this.text = text;
	}
	
boolean first = true;
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		if(first) {
			first = false;
			DialogCreator.createDialog(villain.name,text,null,"Beyblade, Let it RIP!");
			new WildWest(villain);
		}
	}
}