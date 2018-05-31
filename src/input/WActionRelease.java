package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class WActionRelease extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		System.out.println( "The W key has been released." );
	} 
}