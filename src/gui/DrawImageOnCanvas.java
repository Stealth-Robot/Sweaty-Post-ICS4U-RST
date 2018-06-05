package gui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import backend.input.Interact;
import backend.input.MovementFromInputs;
import backend.player.Player;
import gui.scenes.Scene;
import gui.scenes.locations.BarScene;
import gui.scenes.locations.CasinoIScene;
import gui.scenes.locations.DesertScene;
import gui.scenes.locations.LoadingScene;
import gui.scenes.locations.SceneMaster;
import images.ImageData;

public class DrawImageOnCanvas {
	private Display display;
	private Thread t;
	private boolean running;
	private BufferStrategy bs;
	public static Scene currentScene;
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
		int y = Display.SCREEN_HEIGHT - Display.PIXEL_IMAGE_SIZE - (int)player.getPosition().y;
		if(currentOrientation == Player.Movement.SOUTH
				||currentOrientation == Player.Movement.SOUTH_EAST
				||currentOrientation == Player.Movement.SOUTH_WEST) {
			g.drawImage(playerImage.getDownImage(), (int)player.getPosition().x,y ,null);
		}
		else if (currentOrientation == Player.Movement.WEST) {
			g.drawImage(playerImage.getLeftImage(), (int)player.getPosition().x, y,null);
		}
		else if (currentOrientation == Player.Movement.EAST) {
			g.drawImage(playerImage.getRightImage(), (int)player.getPosition().x, y,null);
		}
		else {
			g.drawImage(playerImage.getImage(), (int)player.getPosition().x, y,null);
		}
	}

	private void tick() {
		Vector2 move = MovementFromInputs.getPositionRelativeToInputs();
		Player.Movement m = player.updateCharacter(move.x, move.y);
	//	System.out.println(player.position);
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
		currentScene = new LoadingScene();
		display = new Display();
		player = new Player(Display.PIXEL_IMAGE_SIZE,Display.PIXEL_IMAGE_SIZE,new Vector2(0,0));
		playerImage.createRotationImages();
		SceneMaster.createScenes();
		currentScene = SceneMaster.casinoIScene;
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