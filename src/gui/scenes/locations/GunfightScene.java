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
import gui.objects.colliders.SpeechBattleCollider;
import gui.scenes.Scene;
import images.ImageData;
import main.Main;

public class GunfightScene extends Scene {

	public GunfightScene(int identifier) {
		super(identifier);
		//System.out.print(identifier + ",");
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
			        if(x==0&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeLeft.png");
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	        testImage = ImageLoader.loadImage("src/images/sprites/Enemy.png");
	      
	       
	}

	@Override
	public void createColliders() {
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.endScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
		Image testImage = ImageLoader.loadImage("src/images/sprites/Enemy.png");
			if(Main.Marshall_Virgil.ready) {
	        	postEnvironment.add(new ImageData(testImage,4,3));
	        	addCollider(new Collider(RectangleCreator.colliderRectangle(4,3)));
	        	postEnvironment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/DesertInteractRight.png"),3,3));
		        }
			testImage = ImageLoader.loadImage("src/images/sprites/EneLGreyGold.png");
		        if(Main.Wyatt.ready) {
		        	postEnvironment.add(new ImageData(testImage,5,5));
		        	addCollider(new Collider(RectangleCreator.colliderRectangle(5,5)));
		        	postEnvironment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/DesertInteractRight.png"),4,5));
		        }
		        testImage = ImageLoader.loadImage("src/images/sprites/EneGoldLBlue.png");
		        if(Main.Morgan.ready) {
		        	postEnvironment.add(new ImageData(testImage,7,2));
		        	addCollider(new Collider(RectangleCreator.colliderRectangle(7,2)));
		        	postEnvironment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/DesertInteractRight.png"),6,2));
		        }
		        testImage = ImageLoader.loadImage("src/images/sprites/EneLGoldGold.png");
		        if(Main.Doc_Holliday.ready) {
		        	postEnvironment.add(new ImageData(testImage,6,0));
		        	addCollider(new Collider(RectangleCreator.colliderRectangle(6,0)));
		        	postEnvironment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/DesertInteractRight.png"),5,0));
		        }
	}

	@Override
	public void createBattleColliders() {
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(3, 3), Main.Marshall_Virgil,"I come to kill sheriffs and innocents! I am the evilest bi of them all! I AM THE MARSHALL","I will be the new Marshall."));
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(4, 5), Main.Wyatt,"I am the famousest bad guy of them all. You will die to me like so many others have!","I will take your fame for myself!"));
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(6, 2), Main.Morgan,"Man or Woman? You decide","Uhhh..."));
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(5, 0), Main.Doc_Holliday,"I Doc Holiday! I will heal you to death","Wait... How will you kill me by healing me?"));
	}

}
