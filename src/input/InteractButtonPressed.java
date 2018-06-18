/*
 * InteractButtonPressed.java
 * runs code when the interact button is pressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.Interact;

public class InteractButtonPressed extends AbstractAction
{
	/**
	 * Pre: Is called via a keypress of the associated button
	 * During: Set the InteractPressed boolean to true
	 * Post: 
	 */
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		Interact.setPressed(true);
	} 
}