package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SActionRelease extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		System.out.println( "The S key has been released." );
	} 
}