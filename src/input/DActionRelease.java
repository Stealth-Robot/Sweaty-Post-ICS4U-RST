package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.player.Movement;

public class DActionRelease extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		Movement.RightPressed = false;
	} 
}