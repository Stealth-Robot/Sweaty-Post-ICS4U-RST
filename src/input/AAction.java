package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.player.Movement;

public class AAction extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		Movement.LeftPressed = true;
	} 
}