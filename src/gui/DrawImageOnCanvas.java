package gui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import backend.Movement.MovementFromInputs;
import backend.player.Player;
import gui.scenes.BarScene;
import gui.scenes.CasinoIScene;
import gui.scenes.DesertScene;
import gui.scenes.Scene;
import images.ImageData;

public class DrawImageOnCanvas {
	private Display display;
	private Thread t;
	private boolean running;
	private BufferStrategy bs;
	private Graphics2D g;
	public Scene startScene, desertScene, desertScene2, desertScene3, desertScene4, desertScene5, desertScene6, barScene, casinoScene, trainScene, casinoIScene;
	public Scene currentScene;
	private BufferedImage testImage;

	public Player player;
	ImageData playerImage = new ImageData(ImageLoader.loadImage("src/images/sprites/Player.png"),0,0);
	public DrawImageOnCanvas() {
		System.out.println("init");
		init();
	}

	public void run(Graphics g) {
		//System.err.println("run..." + running);
		tick();
		render(g);
		//stop();
	}

	public Player.Movement currentOrientation = Player.Movement.NONE;
	public void render(Graphics g) {

		currentScene.render(g);
		drawPlayer(g);
	}

	public void drawPlayer(Graphics g) {
		Vector2 move = MovementFromInputs.getPositionRelativeToInputs();
		player.updateCharacter(move.x, move.y);
		if(currentOrientation == Player.Movement.NORTH
				||currentOrientation == Player.Movement.NORTH_EAST
				||currentOrientation == Player.Movement.NORTH_WEST) {
			g.drawImage(playerImage.getDownImage(), (int)player.getPosition().x, (int)player.getPosition().y,null);
		}
		else if (currentOrientation == Player.Movement.WEST) {
			g.drawImage(playerImage.getLeftImage(), (int)player.getPosition().x, (int)player.getPosition().y,null);
		}
		else if (currentOrientation == Player.Movement.EAST) {
			g.drawImage(playerImage.getRightImage(), (int)player.getPosition().x, (int)player.getPosition().y,null);
		}
		else {
			g.drawImage(playerImage.getImage(), (int)player.getPosition().x, (int)player.getPosition().y,null);
		}
	}

	private void tick() {
		Vector2 move = MovementFromInputs.getPositionRelativeToInputs();
		Player.Movement m = player.updateCharacter(move.x, move.y);
		if(m != Player.Movement.NONE) {
			currentOrientation = m;
		}
	}

	public static final class ImageLoader
	{

		public static BufferedImage loadImage(String fileName)
		{
			BufferedImage bi = null;
			//System.err.println("....setimg...." + fileName);

			try {
				bi = ImageIO.read(new File(fileName)); 

			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Image could not be read");
				System.exit(1);
			}

			return bi;
		}
	}

	public void init() {
		System.out.println("INITIALIZE");
		player = new Player(Display.PIXEL_IMAGE_SIZE,Display.PIXEL_IMAGE_SIZE,new Vector2(0,0));
		display = new Display();
		startScene   = new StartScene();
		desertScene  = new DesertScene();
		desertScene2 = new DesertScene();
		desertScene3 = new DesertScene();
		desertScene4 = new DesertScene();
		desertScene5 = new DesertScene();
		desertScene6 = new DesertScene();
		casinoScene  = new DesertScene();
		trainScene   = new DesertScene();
		barScene     = new BarScene();
		casinoIScene = new CasinoIScene();
		currentScene = casinoIScene;
	}

	public synchronized void start() {
		if (running) return;
		running = true;

	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}