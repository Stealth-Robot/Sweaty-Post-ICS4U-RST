package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.SceneChangeCollider;
import gui.scenes.Scene;
import images.ImageData;

public class BarScene extends Scene {
	int identifier;
	public BarScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
		this.identifier = identifier;
	}

	@Override
	public void createEnvironment() {
		 Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
	        for(int x = 0; x < 9; x++) {
	        	for(int y = 0; y < 6; y++) {
	        		if(y>4||y<=3) {
		        		int worldGen = (int) (18 * Math.random() + 1);
				        switch (worldGen)  //switches are used to set the tile based on a random number (1-6)
				        {
				            case 1:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
			        		break;
				            case 2:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
			        		break;
				            case 3:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
			        		break;
				            case 4:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
			        		break;
				            case 5:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
			        		break;
				            default:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor.png");
			        		break;
				        }
				        if(y==2&&x==1||y==1&&x==3||y==2&&x==6) {
				        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/Table.png");
				        }
	        		}
	        		else
	        		{
	        			int railGen = (int) (4 * Math.random() + 1);
	    		        switch (railGen)  //switches are used to set the tile based on a random number (1-6)
	    		        {
	    		            case 1:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarMessy.png");
	    	        		break;
	    		            default:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/Bar.png");
	    	        		break;
	    		        }
	    		        if(x==7)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarCorner.png");
	    		        if(x==8)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor.png");
				        if(x==4)
				        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarInteract.png");
	        		}
			        if(x==1&&y==0)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarExit.png");
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	        testImage = ImageLoader.loadImage("src/images/sprites/interactables/NPCMale.png");
	        environment.add(new ImageData(testImage,4,5));
		
	}

	@Override
	public void createColliders() {
		if(identifier == 1)
			addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(1, 0),SceneMaster.railwayScene, new Vector2(0,1), Player.Movement.NORTH));
	}
}