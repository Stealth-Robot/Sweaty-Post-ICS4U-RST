package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeCollider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.scenes.Scene;
import images.ImageData;

public class JailCellScene extends Scene {

	public JailCellScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
	}

	@Override
	public void createEnvironment() {
		Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 6; y++) {
				if(x>1&&y>0&&x<7&&y<5)
					testImage = ImageLoader.loadImage("src/images/sprites/insidejail/jailFloor.png");
				else
					testImage = ImageLoader.loadImage("src/images/sprites/insidejail/jailBorder.png");
				environment.add(new ImageData(testImage, x, y));
			}
		}
		environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/insidejail/jailBed1.png"), 6, 4));
		environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/insidejail/jailBed2.png"), 6, 3));
		environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/insidejail/jailToilet.png"), 3, 4));
		environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/insidejail/jailExit.png"), 2, 1));
	}

	@Override
	public void createColliders() {

	}
}
