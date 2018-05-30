package gui;
import java.awt.Canvas;
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

public class DrawImageOnCanvas implements Runnable {
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
  
    }

    @Override
    public void run() {
        init();
        while (running) {
            //System.err.println("run..." + running);
        	tick();
            render();
            
        }
        //stop();
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }


        g = (Graphics2D)display.getCanvas().getGraphics();
        for(ImageData image : environment) {
        	g.drawImage(image.getImage(), image.getxPos(), image.getyPos(), null);
        }
        
        g.drawImage(playerImage.getImage(), (int)player.getPosition().x, (int)player.getPosition().y,null);
       
    }

    private void tick() {
    	Vector2 movement = Display.keyMovement.processKeyEvent();
    	Display.keyInteract.processKeyEvent();
    	player.updateCharacter(movement.x, movement.y);
    }

    private static final class ImageLoader
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

    private void init() {
    	player = new Player(Display.PIXEL_IMAGE_SIZE,Display.PIXEL_IMAGE_SIZE,new Vector2(0,0));
        display = new Display();
        testImage = ImageLoader.loadImage("src/images/sprites/environments/Desert.png");
        for(int x = 0; x < 9; x++) {
        	for(int y = 0; y < 6; y++) {
        		environment.add(new ImageData(testImage,x,y));
        	}
        }
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        t = new Thread(this);
        t.start();

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