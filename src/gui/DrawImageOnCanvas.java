package gui;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import images.ImageData;

public class DrawImageOnCanvas implements Runnable {
    private Display Display;
    private Thread t;
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage testImage;
    public ArrayList<ImageData> environment = new ArrayList<ImageData>();
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
        bs = Display.getCanvas().getBufferStrategy();

        if (bs == null) {
            Display.getCanvas().createBufferStrategy(3);
            return;
        }


        g = Display.getCanvas().getGraphics();
        for(ImageData image : environment) {
        	g.drawImage(image.getImage(), image.getxPos(), image.getyPos(), null);
        }
    }

    private void tick() {

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
        Display = new Display();
        testImage = ImageLoader.loadImage("src/images/test/box_green.png");
      	environment.add(new ImageData(testImage,0,0));
    	environment.add(new ImageData(testImage,1,1));
    	environment.add(new ImageData(testImage,2,2));
    	environment.add(new ImageData(testImage,3,3));
    	environment.add(new ImageData(testImage,4,4));
    	environment.add(new ImageData(testImage,5,5));
    	environment.add(new ImageData(testImage,6,4));
    	environment.add(new ImageData(testImage,7,3));
    	environment.add(new ImageData(testImage,8,2));
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