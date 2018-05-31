package input;

import java.awt.event.ActionEvent;
import backend.player.Movement;

import javax.swing.AbstractAction;

public class WActionRelease extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		Movement.UpPressed = false;
	} 
}