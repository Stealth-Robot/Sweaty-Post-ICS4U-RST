/*
 * RightMovementButtonPressed.java
 * runs code when the right button is pressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.MovementFromInputs;

public class RightMovementPressed extends AbstractAction
{
	/**
	 * Pre: Is called via a keypress of the associated button
	 * During: Set the RightPressed boolean to true
	 * Post: 
	 */
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.RightPressed = true;
	}
} 