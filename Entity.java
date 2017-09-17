package brh2017.iam.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	public int x = 0;
	public int y = 0;
	public int xVel = 0;
	public int yVel = 0;
	public Color col;
	
	protected int internalTimer = 0;

	public Entity(int x, int y, int xVel, int yVel) {
		this.x = x;
		this.y = y;
		this.xVel = xVel;
		this.yVel = yVel;
	}

	public Entity() {

	}

	public void tick() {
		x += xVel;
		y += yVel;
		x = Main.clamp(x);
		y = Main.clamp(y);
		
		internalTimer++;
	}

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();
}
