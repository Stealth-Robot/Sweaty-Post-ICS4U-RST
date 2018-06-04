package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.MovementFromInputs;

public class UpMovementPressed extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf ) {
		MovementFromInputs.UpPressed = true;
	}
}