package gui.scenes.locations;

import java.awt.Image;

import backend.player.Player;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.scenes.Scene;
import images.ImageData;

public class DesertScene extends Scene {

	private int identifier;
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
			      		break;
	   		        }
	   		        if(x==3&&y==4)
  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseOutsideCorner4.png");
	   		        
///////////////////   Below dosen't work because identifier is seen as 0   ///////////////////////////////////////////////////////////
	   		        if(identifier == 5) {
		   		        if(x==4&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/saloonSign1.png");
		   		        if(x==5&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/saloonSign2.png");
	   		        }
	   		        else if(identifier == 7) {
		   		        if(x==4&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/bankSign1.png");
		   		        if(x==5&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/bankSign2.png");
	   		        }
	   		        else if(identifier == 9) {
		   		        if(x==4&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/jailSign1.png");
		   		        if(x==5&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/jailSign2.png");
	   		        }
	   		        else if(identifier == 11) {
		   		        if(x==4&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/hotelSign1.png");
		   		        if(x==5&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/hotelSign2.png");
	   		        }
	   		        else {
		   		        if(x==4&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseDot.png");
		   		        if(x==5&&y==4)
	  		                testImage = ImageLoader.loadImage("src/images/sprites/environments/house/HouseDot.png");
	   		        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		addCollider(new Collider(RectangleCreator.colliderRectangle(7,4)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(7,5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(3,5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(3,4)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(4,4)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(5,4)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(6,4)));
		if(identifier == 5) {//saloon
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.startScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 2),SceneMaster.bankScene, new Vector2(1,2), Player.Movement.EAST, Player.Movement.EAST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(6, 3.95),SceneMaster.saloonIScene, new Vector2(4,1), Player.Movement.NORTH, Player.Movement.NORTH));
		}
		if(identifier == 7) {//bank
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.saloonScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 2),SceneMaster.jailScene, new Vector2(1,2), Player.Movement.EAST, Player.Movement.EAST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(6, 3.95),SceneMaster.bankIScene, new Vector2(4,1), Player.Movement.NORTH, Player.Movement.NORTH));
		}
		if(identifier == 9) {//jail
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.bankScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 2),SceneMaster.hotelScene, new Vector2(1,2), Player.Movement.EAST, Player.Movement.EAST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(6, 3.95),SceneMaster.jailIScene, new Vector2(4,1), Player.Movement.NORTH, Player.Movement.NORTH));
		}
		if(identifier == 11) {//hotel
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(-0.95, 2),SceneMaster.jailScene, new Vector2(7,2), Player.Movement.WEST, Player.Movement.WEST));
			//addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(8.95, 2),SceneMaster.bankScene, new Vector2(1,2), Player.Movement.EAST, Player.Movement.EAST));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(6, 3.95),SceneMaster.hotelIScene, new Vector2(4,1), Player.Movement.NORTH, Player.Movement.NORTH));
		}
	}

}
