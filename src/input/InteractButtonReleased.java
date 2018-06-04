package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.Interact;

public class InteractButtonReleased extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		Interact.setPressed(false);
	} 
}