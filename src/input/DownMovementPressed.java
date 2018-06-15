/*
 * DownMovementButtonPressed.java
 * runs code when the down button is pressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.MovementFromInputs;

public class DownMovementPressed extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.DownPressed = true;
	}
} 