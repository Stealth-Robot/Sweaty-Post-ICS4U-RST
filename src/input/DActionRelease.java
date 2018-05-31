package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DActionRelease extends AbstractAction
{
	public void actionPerformed( ActionEvent tf )
	{
		System.out.println( "The D key has been released." );
	} 
}