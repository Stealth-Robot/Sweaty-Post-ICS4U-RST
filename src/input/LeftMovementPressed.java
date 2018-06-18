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
	/**
	 * Pre: Is called via a keypress of the associated button
	 * During: Set the LeftPressed boolean to true
	 * Post: 
	 */
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.LeftPressed = true;
	} 
}