package gui;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import backend.player.Player;
import images.ImageData;

public class DrawImageOnCanvas {
    private Display display;
    private Thread t;
    private boolean running;
    private BufferStrategy bs;
    private Graphics2D g;
    private BufferedImage testImage;
    public ArrayList<ImageData> environment = new ArrayList<ImageData>();
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

    public void render(Graphics g) {
        ImageData image = environment.get(2);
        	g.drawImage(image.getImage(), image.getxPos(), image.getyPos(), null);
        g.drawImage(playerImage.getImage(), (int)player.getPosition().x, (int)player.getPosition().y,null);

    }

    private void tick() {
    	Vector2 movement = Display.keyPress.processKeyEvent();
    	player.updateCharacter(movement.x, movement.y);
    }

    public static final class ImageLoader
    {

        static BufferedImage loadImage(String fileName)
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
        testImage = ImageLoader.loadImage("src/images/test/box_green.png");
        for(int x = 0; x < 9; x++) {
        	for(int y = 0; y < 6; y++) {
        		environment.add(new ImageData(testImage,x,y));
        	}
        }
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