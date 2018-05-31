package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.player.Movement;

public class SAction extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		Movement.DownPressed = true;
	}
} 