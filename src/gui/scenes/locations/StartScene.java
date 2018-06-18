/*
 * StartScene.java
 * generates the starting scene
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.Vector2;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeCollider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.objects.colliders.SpeechBattleCollider;
import gui.objects.colliders.SpeechCollider;
import gui.scenes.Scene;
import images.ImageData;
import main.Main;

public class StartScene extends Scene {

	public StartScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
	}

	@Override
	public void createEnvironment() {
		 Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
	        for(int x = 0; x < 9; x++) {
	        	for(int y = 0; y < 6; y++) {
	        		if(y>0) {
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
	        		}
	        		else
	        		{
	        			int railGen = (int) (6 * Math.random() + 1);
	    		        switch (railGen)  //switches are used to set the tile based on a random number (1-6)
	    		        {
	    		            case 1:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/RailBroken1.png");
	    	        		break;
	    		            case 2:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/RailBroken2.png");
	    	        		break;
	    		            default:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Rail.png");
	    	        		break;
	    		        }
	    		        if(x==8)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
	    		        if(x==7)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/RailEnd.png");
	        		}
			        if(x==8&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeRight.png");
			        if(x==0&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeLeft.png");
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
		
	}

	@Override
	public void createColliders() {
		/*if(Main.Marshall_Virgil.ready) {
			addCollider(new Collider(RectangleCreator.colliderRectangle(4,3)));
		}
		addCollider(new Collider(RectangleCreator.colliderRectangle(5,5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(7,2)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(6,0)));*/
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 2),SceneMaster.saloonScene, new Vector2(1,2), Player.Movement.EAST,Player.Movement.EAST));
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.railwayScene, new Vector2(7,2), Player.Movement.WEST,Player.Movement.WEST));
	}

	@Override
	public void createBattleColliders() {
		/*if(Main.Marshall_Virgil.ready) {
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(3, 3), Main.Marshall_Virgil,"Oof Oof Oof here comes dat boi","K lol"));
		}
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(4, 5), Main.Wyatt,"Oof Oof Oof here comes dat boi","K lol"));
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(6, 2), Main.Morgan,"Oof Oof Oof here comes dat boi","K lol"));
		addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(5, 0), Main.Doc_Holliday,"Oof Oof Oof here comes dat boi","K lol"));*/
	}

}
