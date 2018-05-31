package input;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class DAction extends AbstractAction
{
	@Override
	public void actionPerformed( ActionEvent tf )
	{
		System.out.println( "The D key has been pressed." );

	}
} 