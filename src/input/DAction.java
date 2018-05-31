package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.player.MovementFromInputs;

public class DAction extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.RightPressed = true;
	}
} 