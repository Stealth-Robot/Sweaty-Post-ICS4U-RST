package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class AAction extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		System.out.println( "The A key has been pressed." );
	} 
}