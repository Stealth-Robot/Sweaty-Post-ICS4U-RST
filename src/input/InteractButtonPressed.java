package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import backend.input.Interact;

public class InteractButtonPressed extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		Interact.setPressed(true);
	} 
}