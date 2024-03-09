package tp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	DemoPanel dp;

	public KeyHandler(DemoPanel dp) {
		this.dp = dp;
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {
			// dp.search();
			dp.autosearch();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

}
