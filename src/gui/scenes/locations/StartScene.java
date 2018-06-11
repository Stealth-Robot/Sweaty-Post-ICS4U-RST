package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.Vector2;
import gui.objects.RectangleCreator;
import gui.objects.colliders.SceneChangeCollider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.scenes.Scene;
import images.ImageData;

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
			        if(x==8&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeRight.png");
			        if(x==0&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeLeft.png");
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
		
	}

	@Override
	public void createColliders() {
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 3),SceneMaster.saloonScene));
		addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(0, 3),SceneMaster.railwayScene, new Vector2(7.9,3), Player.Movement.WEST));
	}

}
