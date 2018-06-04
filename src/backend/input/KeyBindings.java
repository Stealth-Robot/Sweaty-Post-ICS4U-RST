package backend.input;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.KeyStroke;

import gui.Draw;
import input.DownMovementPressed;
import input.DownMovementReleased;
import input.InteractButtonPressed;
import input.InteractButtonReleased;
import input.LeftMovementPressed;
import input.LeftMovementReleased;
import input.RightMovementPressed;
import input.RightMovementReleased;
import input.UpMovementPressed;
import input.UpMovementReleased;

public class KeyBindings {
	public static Draw initKeyBindings(Draw canvas) {
		canvas = aKeyBinding(canvas);
		canvas = leftKeyBinding(canvas);
		canvas = dKeyBinding(canvas);
		canvas = rightKeyBinding(canvas);
		canvas = sKeyBinding(canvas);
		canvas = downKeyBinding(canvas);
		canvas = wKeyBinding(canvas);
		canvas = upKeyBinding(canvas);
		canvas = interactKeyBinding(canvas);
		return canvas;
	}

	private static Draw aKeyBinding(Draw canvas) {
		Action aAction = new LeftMovementPressed();
		Action aActionRelease = new LeftMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_A, 0,false)), "doaAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_A, 0,true)), "doaActionRelease");
		canvas.getActionMap().put( "doaActionRelease", aActionRelease );
		canvas.getActionMap().put( "doaAction", aAction );
		return canvas;
	}

	private static Draw leftKeyBinding(Draw canvas) {
		Action leftAction = new LeftMovementPressed();
		Action leftActionRelease = new LeftMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0,false)), "doaAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0,true)), "doaActionRelease");
		canvas.getActionMap().put( "doaActionRelease", leftActionRelease );
		canvas.getActionMap().put( "doaAction", leftAction );
		return canvas;
	}
	
	private static Draw dKeyBinding(Draw canvas) {
		Action dAction = new RightMovementPressed();
		Action dActionRelease = new RightMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_D, 0,false)), "dodAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_D, 0,true)), "dodActionRelease");
		canvas.getActionMap().put( "dodAction", dAction );
		canvas.getActionMap().put( "dodActionRelease", dActionRelease );
		return canvas;
	}
	
	private static Draw rightKeyBinding(Draw canvas) {
		Action rightAction = new RightMovementPressed();
		Action rightActionRelease = new RightMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0,false)), "dodAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0,true)), "dodActionRelease");
		canvas.getActionMap().put( "dodAction", rightAction );
		canvas.getActionMap().put( "dodActionRelease", rightActionRelease );
		return canvas;
	}

	private static Draw sKeyBinding(Draw canvas) {
		Action sAction = new DownMovementPressed();
		Action sActionRelease = new DownMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_S, 0,false)), "dosAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_S, 0,true)), "dosActionRelease");
		canvas.getActionMap().put( "dosAction", sAction );
		canvas.getActionMap().put( "dosActionRelease", sActionRelease );
		return canvas;
	}
	
	private static Draw downKeyBinding(Draw canvas) {
		Action downAction = new DownMovementPressed();
		Action downActionRelease = new DownMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0,false)), "dosAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0,true)), "dosActionRelease");
		canvas.getActionMap().put( "dosAction", downAction );
		canvas.getActionMap().put( "dosActionRelease", downActionRelease );
		return canvas;
	}
	
	private static Draw wKeyBinding(Draw canvas) {
		Action wAction = new UpMovementPressed();
		Action wActionRelease = new UpMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_W, 0,false)), "dowAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_W, 0,true)), "dowActionRelease");
		canvas.getActionMap().put( "dowAction", wAction );
		canvas.getActionMap().put( "dowActionRelease", wActionRelease );
		return canvas;
	}
	
	private static Draw upKeyBinding(Draw canvas) {
		Action upAction = new UpMovementPressed();
		Action upActionRelease = new UpMovementReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0,false)), "dowAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0,true)), "dowActionRelease");
		canvas.getActionMap().put( "dowAction", upAction );
		canvas.getActionMap().put( "dowActionRelease", upActionRelease );
		return canvas;
	}
	
	private static Draw interactKeyBinding(Draw canvas) {
		Action interactAction = new InteractButtonPressed();
		Action interactActionRelease = new InteractButtonReleased();
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_E, 0,false)), "doeAction");
		canvas.getInputMap().put((KeyStroke.getKeyStroke(KeyEvent.VK_E, 0,true)), "doeActionRelease");
		canvas.getActionMap().put( "doeAction", interactAction );
		canvas.getActionMap().put( "doeActionRelease", interactActionRelease );
		return canvas;
	}

}
