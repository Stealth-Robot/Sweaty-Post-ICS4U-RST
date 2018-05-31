package input;

import java.awt.event.ActionEvent;
import backend.player.MovementFromInputs;

import javax.swing.AbstractAction;

public class WActionRelease extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.UpPressed = false;
	} 
}