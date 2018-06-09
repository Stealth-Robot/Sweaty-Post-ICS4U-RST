package gui.scenes.locations;

import java.awt.Image;

import gui.DrawImageOnCanvas.ImageLoader;
import gui.scenes.Scene;
import images.ImageData;

public class DesertScene extends Scene {

	public DesertScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
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
			        if(x==8&&y==3)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeRight.png");
			        if(x==4&&y==0)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeDown.png");
			        if(x==4&&y==5)
			        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/DesertChangeUp.png");
			       environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	}

	@Override
	public void createColliders() {
		// TODO Auto-generated method stub
		
	}

}
