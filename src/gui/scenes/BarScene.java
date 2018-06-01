package gui.scenes;

import java.awt.Image;

import gui.DrawImageOnCanvas.ImageLoader;
import images.ImageData;

public class BarScene extends Scene {

	@Override
	public void instantiate() {
		 Image testImage = ImageLoader.loadImage("src/images/sprites/environments/Desert.png");
	        for(int x = 0; x < 9; x++) {
	        	for(int y = 0; y < 6; y++) {
	        		if(y>4||y<=3) {
		        		int worldGen = (int) (18 * Math.random() + 1);
				        switch (worldGen)  //switches are used to set the tile based on a random number (1-6)
				        {
				            case 1:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor2.png");
			        		break;
				            case 2:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor2.png");
			        		break;
				            case 3:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor2.png");
			        		break;
				            case 4:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor2.png");
			        		break;
				            case 5:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor2.png");
			        		break;
				            default:  
				                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor.png");
			        		break;
				        }
				        if(y==2&&x==1||y==1&&x==3||y==2&&x==6) {
				        	testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor3.png");
				        }
	        		}
	        		else
	        		{
	        			int railGen = (int) (4 * Math.random() + 1);
	    		        switch (railGen)  //switches are used to set the tile based on a random number (1-6)
	    		        {
	    		            case 1:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/BarMessy.png");
	    	        		break;
	    		            default:  
	    		                testImage = ImageLoader.loadImage("src/images/sprites/environments/Bar.png");
	    	        		break;
	    		        }
	    		        if(x==7)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/BarCorner.png");
	    		        if(x==8)
	    		        	testImage = ImageLoader.loadImage("src/images/sprites/environments/BarFloor.png");
				        if(x==4)
				        	testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarInteract.png");
	        		}
			        environment.add(new ImageData(testImage,x,y));
	        	}
	        }
	        testImage = ImageLoader.loadImage("src/images/sprites/interactables/NPCMale.png");
	        environment.add(new ImageData(testImage,4,5));
		
	}

}
