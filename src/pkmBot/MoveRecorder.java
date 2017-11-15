package pkmBot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveRecorder implements KeyListener {
	static long start = 0;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (start == 0) {
			start = System.currentTimeMillis();
		}
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		e.consume();
		System.out.println(
				KeyEvent.getKeyText(e.getKeyCode()) + ":" + String.valueOf(System.currentTimeMillis() - start));

		start=0;
	}

}
