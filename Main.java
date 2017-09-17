package brh2017.iam.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 4680391352992944109L;

	public static ArrayList<Entity> h = new ArrayList<Entity>();

	public static boolean gameOver = false;
	private boolean running = false;
	private Thread thread;
	public static int size = 800;
	public static Random rand;
	public static JFrame frame;
	public static boolean paintIt = false;
	private static int frameCounter = 0;
	private static boolean frameUp = true;

	public Main() {
		rand = new Random();
		this.addKeyListener(new KeyInput());

		frame = new JFrame("Interactive Art Module");
		frame.setSize(size, size);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(this);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);

		this.start();

		h.add(new Player(size / 2 - 20, size / 2 - 20, 0, 0));
		for (int i = 0; i < 8; i++) {
			h.add(new NPC(rand.nextInt(size - 30), rand.nextInt(size - 30), 0, 0));
		}

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}

	public void tick() {
		if (gameOver) {
			this.stop();
		}

		for (int i = 0; i < h.size(); i++) {
			h.get(i).tick();
		}

		if (frameCounter % 3 == 0) {
			if (frameUp) {
				Main.size += 1;
			} else {
				Main.size -= 1;
			}
			Main.frame.setSize(size, size);
		}
		if (Main.size > 1000) {
			frameUp = false;
		} else if (Main.size < 400) {
			frameUp = true;
		}
		frameCounter++;
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, size, size);

		for (int i = 0; i < h.size(); i++) {
			h.get(i).render(g);
		}

		if (paintIt) {
			g.setColor(Color.WHITE);
			g.fillRect(Main.rand.nextInt(Main.size) - 100, Main.rand.nextInt(Main.size) - 100, 100, 100);
			paintIt = false;
		}

		g.dispose();
		bs.show();
	}

	public static int clamp(int pos) {
		if (pos > size) {
			pos = 0;
		} else if (pos < 0) {
			pos = size;
		}
		return pos;
	}

	public static void main(String[] args) throws InterruptedException {
		new Main();
	}
}