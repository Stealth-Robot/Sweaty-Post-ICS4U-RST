package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.scenes.Scene;
import images.ImageData;

public class DesertScene extends Scene {

	int identifier;
	public DesertScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
		this.identifier = identifier;
	}

	@Override
	public void createEnvironment() {
		 Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
	        for(int x = 0; x < 9; x++) {
	        	for(int y = 0; y < 6; y++) {
		       		int worldGen = (int) (18 * Math.random());
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
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/desert.png");
			      		break;
	   		        }
	   		        if(x==3&&y==4)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner4.png");
	   		        if(x==4&&y==4)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseDot.png");
	   		        if(x==5&&y==4)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseDot.png");
	   		        if(x==6&&y==4)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseStep.png");
	   		        if(x==6&&y==3)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/Steps.png");
	   		        if(x==7&&y==4)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner3.png");
	   		        if(x==3&&y==5)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeLeft.png");
	   		        if(x==4&&y==5)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseInsideCorner3.png");
	   		        if(x==5&&y==5)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeInsideDown.png");
	   		        if(x==6&&y==5)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseInsideCorner4.png");
	   		        if(x==7&&y==5)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseEdgeRight.png");
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
		if(identifier == 5) {
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.startScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
			//addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.startScene, new Vector2(7,2), Player.Movement.NORTH, Player.Movement.NORTH));
			//addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.startScene, new Vector2(7,2), Player.Movement.EAST, Player.Movement.EAST));
		}
	}

}
