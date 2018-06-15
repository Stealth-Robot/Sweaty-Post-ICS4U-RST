/*
 * LeftMovementButtonPressed.java
 * runs code when the left button is pressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.MovementFromInputs;

public class LeftMovementPressed extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.LeftPressed = true;
	} 
}