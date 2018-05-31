package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.player.MovementFromInputs;

public class AAction extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.LeftPressed = true;
	} 
}