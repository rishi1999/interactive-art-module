package brh2017.iam.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			Main.h.get(0).yVel = -5;
		} else if (key == KeyEvent.VK_DOWN) {
			Main.h.get(0).yVel = 5;
		} else if (key == KeyEvent.VK_LEFT) {
			Main.h.get(0).xVel = -5;
		} else if (key == KeyEvent.VK_RIGHT) {
			Main.h.get(0).xVel = 5;
		} else if (key == KeyEvent.VK_SPACE) {
			Main.paintIt = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			Main.h.get(0).yVel = 0;
		} else if (key == KeyEvent.VK_DOWN) {
			Main.h.get(0).yVel = 0;
		} else if (key == KeyEvent.VK_LEFT) {
			Main.h.get(0).xVel = 0;
		} else if (key == KeyEvent.VK_RIGHT) {
			Main.h.get(0).xVel = 0;
		}
	}
}
