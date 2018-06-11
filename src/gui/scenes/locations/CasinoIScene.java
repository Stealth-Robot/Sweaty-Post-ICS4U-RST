package gui.scenes.locations;

import java.awt.Image;

import gui.DrawImageOnCanvas.ImageLoader;
import gui.Vector2;
import gui.objects.RectangleCreator;
import gui.objects.colliders.BattleCollider;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeCollider;
import gui.scenes.Scene;
import images.ImageData;

public class CasinoIScene extends Scene {

	int identifier;
	public CasinoIScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
		this.identifier = identifier;
	}

	@Override
	public void createEnvironment() {
		 Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
	        for(int x = 0; x < 9; x++) {
	        	for(int y = 0; y < 6; y++) {
	        		if(y>4||y<=3||y==4&&x>=3) {
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
				        if(y==1&&x==4)
				        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BlackjackTable.png");
				        if(y==4&&x==4)
				        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/NumGuessTable.png");
				        if(y==4&&x==7)
				        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/DieTable.png");
				        if(y==1&&x==7)
				        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/RPSTable.png");
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
	    		        if(x==2)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarCorner.png");
				        if(x==1)
				        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarInteract.png");
	        		}
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	        testImage = ImageLoader.loadImage("src/images/sprites/interactables/NPCMale.png");
	        environment.add(new ImageData(testImage,1,5));
	        testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarExit.png");
	        environment.add(new ImageData(testImage,1,0));
	}

	@Override
	public void createColliders() {
		if(identifier == 4)
			addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(1, 0),SceneMaster.startScene, new Vector2(1,1)));
		if(identifier == 12)
			addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(1, 0),SceneMaster.startScene, new Vector2(1,1)));
		/*addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(7, 4),SceneMaster.startScene));
		addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(4, 4),SceneMaster.startScene));
		addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(7, 1),SceneMaster.startScene)); //they work but need to be battle colliders
		addCollider(new SceneChangeCollider(RectangleCreator.colliderRectangle(4, 1),SceneMaster.startScene));*/
		
	}
}
