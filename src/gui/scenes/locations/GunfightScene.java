/*
 * GunfightScene.java
 * generates the gunfight scene
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes.locations;

import java.awt.Image;

import PresentationClasses.Villain;
import backend.player.Player;
import gui.DrawImageOnCanvas;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.BattleCollider;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeCollider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.scenes.Scene;
import images.ImageData;
import main.Main;

public class GunfightScene extends Scene {

	public GunfightScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
	}

	@Override
	public void createEnvironment() {
		 Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
	        for(int x = 0; x < 9; x++) {
	        	for(int y = 0; y < 6; y++) {
		        	int worldGen = (int) (18 * Math.random() + 1);
				    switch (worldGen)  //switches are used to set the tile based on a random number (1-6)
				    {
				    	case 1:  
				    		testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/DesertRock.png");
				    		break;
			           case 2:  
			            	testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/DesertFlower.png");
		        		break;
			            default:  
			            	int desertGen = (int) (3 * Math.random() + 1);
			            	switch (desertGen)  //switches are used to set the tile based on a random number (1-6)
			    		    {
			   		            case 1:  
			   		            	testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert2.png");
			   	        		break;
		    		            case 2:  
		    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert3.png");
		    	        		break;
		    		            default:  
		    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
		    	        		break;
		    		        }
		        		break;
			        }
			        if(x==7&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeLeft.png");
			        if(x==0&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeLeft.png");
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	        testImage = ImageLoader.loadImage("src/images/sprites/Enemy.png");
	        environment.add(new ImageData(testImage,7,3));
		
	}

	@Override
	public void createColliders() {
		addCollider(new Collider(RectangleCreator.colliderRectangle(7,3)));
		addCollider(new BattleCollider(1, 1, new Vector2(0,0), Main.Slimy));
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.endScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
	}

}
