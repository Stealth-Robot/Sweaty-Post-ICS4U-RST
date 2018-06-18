package gui.objects.colliders.dialog;

import backend.input.MovementFromInputs;
import dialog.DialogCreator;
import gui.objects.Rectangle;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.Collider.Collisions;
import main.Main;

public class RailwayCollider extends SpeechCollider {

	public RailwayCollider(Rectangle rectangle) {
		super(rectangle);
	}
	boolean first = true;
	/**
	 * pre: onCollision
	 * post: overrides action
	 */
	@Override
	public void onCollision(Collider collision, Collisions direction) {
		
		if(first && MovementFromInputs.RightPressed == false && MovementFromInputs.LeftPressed == false && 
				MovementFromInputs.UpPressed == false && MovementFromInputs.DownPressed == false) {
			
			first = false;
			DialogCreator.createDialog("Station Master","Took you long enough... For completing your first task heres 10 of my finest damsels ;)",null,"Sweet thanks mate");
			Main.game.player.damsels+=10;
		}
		else {
			DialogCreator.createDialog("Station Master", "Dont think you can scam me buddy boy I know youve been here already",null, ":P");
		}
	}
}
