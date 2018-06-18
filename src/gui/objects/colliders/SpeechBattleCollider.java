package gui.objects.colliders;

import PresentationClasses.Villain;
import backend.input.MovementFromInputs;
import dialog.DialogCreator;
import gui.objects.Rectangle;
import minigames.WildWest;

public class SpeechBattleCollider extends InteractableColliderNoConstraint {
	public Villain villain;
	public String text;
	public String okMessage;
	public SpeechBattleCollider(Rectangle r, Villain villain,String text, String okMessage) {
		super(r);
		this.villain = villain;
		this.text = text;
		this.okMessage = okMessage;
	}
	
boolean first = true;
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		if(first) {
			first = false;
			DialogCreator.createDialog(villain.name,text,null,okMessage);
			new WildWest(villain);
		}
	}
}