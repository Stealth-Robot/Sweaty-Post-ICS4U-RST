package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeCollider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.scenes.Scene;
import images.ImageData;

public class RailwayScene extends Scene {

	public RailwayScene(int identifier) {
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
	        		}
			        if(x==8&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeRight.png");
			        
			        if(x==0&&y==5)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner1.png");
			        if(x==5&&y==5)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner2.png");
			        if(x==5&&y==2||x==2&&y==1)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner3.png");
			        if(x==0&&y==1)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner4.png");
			        
			        if(x==1&&y==1||x==3&&y==2||x==4&&y==2||x==3&&y==3||x==2&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeDown.png");
			        if(x==1&&y==5||x==2&&y==5||x==2&&y==4||x==3&&y==5||x==3&&y==4||x==4&&y==5)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeUp.png");
			        if(x==5&&y==3||x==5&&y==4)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeRight.png");
			        if(x==0&&y==3||x==0&&y==4||x==0&&y==2||x==1&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeLeft.png");

			        if(x==3&&y==3||x==2&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeInsideDown.png");
			        if(x==3&&y==4||x==2&&y==4)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeInsideUp.png");
			        
			        if(x==1&&y==4)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseInsideCorner1.png");
			        if(x==4&&y==4)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseInsideCorner2.png");
			        if(x==4&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseInsideCorner4.png");
			        if(x==1&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseU.png");
			        if(x==2&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseDiagonal.png");
			        if(x==1&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseDot.png");
			        if(x==4&&y==1)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/Steps.png");
			        if(x==4&&y==2)
			        	testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseStep.png");
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	}

	@Override
	public void createColliders() {
		addCollider(new Collider(RectangleCreator.colliderRectangle(0,1)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(1,1)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(2,1)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(2,2)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(3,2)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(5,2)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(5,3)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(5,4)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(5,5)));
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(4, 2),SceneMaster.railwayIScene, new Vector2(4,1), Player.Movement.NORTH));
		addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 3),SceneMaster.startScene, new Vector2(1,3), Player.Movement.EAST));
	}
}