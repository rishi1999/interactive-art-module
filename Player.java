package brh2017.iam.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Entity {
	public Player(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel);
		col = new Color(Main.rand.nextInt(256), Main.rand.nextInt(256), Main.rand.nextInt(256));
	}

	public Player() {
		super();
		col = new Color(Main.rand.nextInt(256), Main.rand.nextInt(256), Main.rand.nextInt(256));
	}

	@Override
	public void render(Graphics g) {
		if (internalTimer % 15 == 0) {
			col = new Color((col.getRed() + 4) % 128, (col.getGreen() + 4) % 128, (col.getBlue() + 4) % 128);
		}
		g.setColor(col);
		g.fillOval(x, y, 40, 40);
		g.fillOval(Main.size - (x + 20) - 20, y, 40, 40);
		g.fillOval(x, Main.size - (y + 20) - 20, 40, 40);
		g.fillOval(Main.size - (x + 20) - 20, Main.size - (y + 20) - 20, 40, 40);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 40, 40);
	}

}
