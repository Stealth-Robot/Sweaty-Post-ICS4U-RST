package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SAction extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		System.out.println( "The S key has been pressed." );

	}
} 