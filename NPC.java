package brh2017.iam.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class NPC extends Entity {
	int standardSpeed = 40;
	

	public NPC(int x, int y, int xVel, int yVel) {
		super(x, y, xVel, yVel);
		int startColor = Main.rand.nextInt(3);
		switch (startColor) {
		case 0:
			col = Color.RED;
			break;
		case 1:
			col = Color.GREEN;
			break;
		case 2:
			col = Color.BLUE;
			break;
		}
	}

	public NPC() {
		super();
		int startColor = Main.rand.nextInt(3);
		switch (startColor) {
		case 0:
			col = Color.RED;
			break;
		case 1:
			col = Color.GREEN;
			break;
		case 2:
			col = Color.BLUE;
			break;
		}
	}

	@Override
	public void tick() {
		super.tick();
		
		if (internalTimer % 50 == 0) {
			int direction = Main.rand.nextInt(3);
			switch (direction) {
			case 0:
				xVel = -standardSpeed;
				break;
			case 1:
				xVel = 0;
				break;
			case 2:
				xVel = standardSpeed;
				break;
			}
			
			direction = Main.rand.nextInt(3);
			switch (direction) {
			case 0:
				yVel = -standardSpeed;
				break;
			case 1:
				yVel = 0;
				break;
			case 2:
				yVel = standardSpeed;
				break;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		if (internalTimer % 120 == 0) {
			col = new Color((int) (col.getRed() * 1.5) % 128 + 128, (int) (col.getGreen() * 1.2) % 128 + 128, (int) (col.getBlue() * 1.2) % 128 + 128);
		}
		g.setColor(col);
		g.fillRect(x, y, 30, 30);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}

}
