package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.Movement.MovementFromInputs;

public class DownMovementReleased extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.DownPressed = false;
	} 
}