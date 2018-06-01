package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.Movement.MovementFromInputs;

public class RightMovementPressed extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.RightPressed = true;
	}
} 