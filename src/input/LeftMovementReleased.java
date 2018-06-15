/*
 * LeftMovementButtonReleased.java
 * stops running the code in leftmovementbuttonpressed
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.MovementFromInputs;

public class LeftMovementReleased extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		MovementFromInputs.LeftPressed = false;
	} 
}