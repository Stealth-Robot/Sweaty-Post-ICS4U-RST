/*
 * JailCellScene.java
 * generates the jailcell scene
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
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
import gui.objects.colliders.SpeechBattleCollider;
import gui.scenes.Scene;
import images.ImageData;
import main.Main;

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
    	addCollider(new Collider(RectangleCreator.colliderRectangle(1,0)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(1,1)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(1,2)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(1,3)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(1,4)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(1,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(2,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(3,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(4,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(5,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(6,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(7,5)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(7,4)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(7,3)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(7,2)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(7,1)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(7,0)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(6,0)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(5,0)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(4,0)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(3,0)));
    	addCollider(new Collider(RectangleCreator.colliderRectangle(2,0)));
		Image testImage = ImageLoader.loadImage("src/images/sprites/Enemy.png");
		if(identifier == 15)
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(2, 0.05),
				SceneMaster.jailIScene, new Vector2(1, 5), Player.Movement.NORTH, Player.Movement.SOUTH));
		if(identifier == 16)
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(2, 0.05),
			SceneMaster.jailIScene, new Vector2(3, 5), Player.Movement.NORTH, Player.Movement.SOUTH));
		if(identifier == 17)
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(2, 0.05),
				SceneMaster.jailIScene, new Vector2(5, 5), Player.Movement.NORTH, Player.Movement.SOUTH));
	       if(identifier==17) {
		        testImage = ImageLoader.loadImage("src/images/sprites/EnemyDown.png");
		        if(Main.Surfer_Boi.ready) {
		        	postEnvironment.add(new ImageData(testImage,5,4));
		        	addCollider(new Collider(RectangleCreator.colliderRectangle(5,4)));
		        	postEnvironment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/JailInteract.png"),5,3));
		        }
	       }
	}

	@Override
	public void createBattleColliders() {
		if(identifier==17)
			addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(5, 3), Main.Surfer_Boi,"Heey Duude! Im already in jail leave me alone","... You know what? I would, but you are too gay and happy to be left alive"));

	}
}
