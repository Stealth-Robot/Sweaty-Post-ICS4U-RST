package gui;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawImageOnCanvas implements Runnable {
    private Display Display;
    private Thread t;
    private boolean running;
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage testImage;

    public DrawImageOnCanvas() {
    }

    @Override
    public void run() {
        init();
        System.err.println("run..." + running);
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
            System.out.println("bs is null....");
            Display.getCanvas().createBufferStrategy(3);
            return;
        }


        g = Display.getCanvas().getGraphics();
        g.drawImage(testImage, 0, 0, null);
        g.drawImage(testImage, 16, 16, null);
        g.drawImage(testImage, 0, 16, null);
        g.drawImage(testImage, 16, 0, null);
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