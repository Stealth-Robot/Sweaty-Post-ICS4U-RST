package backend.player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPressDetection extends KeyAdapter{

	public int KeyPressHor(KeyEvent event) {
		int x = 0;
		char ch = event.getKeyChar();
		if (ch == 'a' ||ch == 'd') {
			if (ch == 'a') x++;
			else x--;
		}
		return x;
	}

	public int KeyPressVer(KeyEvent event)  {
		int y = 0;
		char ch = event.getKeyChar();
		if (ch == 's'||ch == 'w') {
			if (ch == 's') y = -1;
			else y--;
		} else y = 0;
		return y;
	}
}
