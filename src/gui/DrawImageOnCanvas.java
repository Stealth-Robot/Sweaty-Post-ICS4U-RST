/*
 * DrawImageOnCanvas.java
 * draws everything to the screen
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
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
import dialog.DialogCreator;
import gui.scenes.Scene;
import gui.scenes.locations.BarScene;
import gui.scenes.locations.CasinoIScene;
import gui.scenes.locations.DesertScene;
import gui.scenes.locations.LoadingScene;
import gui.scenes.locations.SceneMaster;
import images.ImageData;
import main.Main;

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
		//System.out.println("init");
		init();
	}
boolean first = true;
	public void run(Graphics g) {
		//System.err.println("run..." + running);
		if(!Main.paused) {
			tick();
		}
		if(Main.gameProgress >= 8 && first) {
			first = false;
			DialogCreator.createDialog("God", "And on that day you did it. You won. \n You have killed everyone, I hope you're proud of yourself.\n You ended up with " + Main.game.player.damsels + " damsels, not too shabby but could be better.\n",null,"Where is the credits scene?");
			System.exit(0);
		}
		render(g);
		//stop();
	}

	public Player.Movement currentOrientation = Player.Movement.NONE;
	/*
	 * Renders the graphics.
	 * Pre: graphics object
	 * Post: tick rendered
	 */
	public void render(Graphics g) {
		currentScene.render(g);
		currentScene.postRender(g);
		drawPlayer(g);
	}

	/*
	 * Draws the player
	 * pre:graphics object
	 * post:plaYer is drawn to screen
	 */
	public void drawPlayer(Graphics g) {
		//Vector2 move = MovementFromInputs.getPositionRelativeToInputs();
		//player.updateCharacter(move.x, move.y);
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

	/*
	 * Tick method
	 * Pre:tick has not been processed
	 * Post:everything but graphics processed
	 */
	private void tick() {
		Vector2 move = MovementFromInputs.getPositionRelativeToInputs();
		Player.Movement m = player.updateCharacter(move.x, move.y);
		if(m != Player.Movement.NONE) {
			player.facingDir = m;
		}
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

	/*
	 * Initializes the game
	 * Pre: nothing
	 * Post: game screen created
	 */
	public void init() {
		//System.out.println("INITIALIZE");
		new LoadingScene(0).initialize();
		display = new Display();
		player = new Player(Display.PIXEL_IMAGE_SIZE - 1,Display.PIXEL_IMAGE_SIZE - 1,new Vector2(0,0));
		playerImage.createRotationImages();
		SceneMaster.createScenes();
		SceneMaster.railwayIScene.initialize();
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