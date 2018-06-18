/*
 * LoadingScene.java
 * generates the a loading screen
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes.locations;

import gui.DrawImageOnCanvas.ImageLoader;
import gui.scenes.Scene;
import images.ImageData;

public class LoadingScene extends Scene {


	/**
	 * Pre: none
	 * Post: Creates the scene for the scene
	 */
	public LoadingScene(int identifier) {
		super(identifier);
		//System.out.print(identifier + ",");
	}


	/**
	 * Pre: none
	 * Post: Creates the envoirnment for the scene
	 */
	@Override
	public void createEnvironment() {
		//environment.add(new ImageData(ImageLoader.loadImage("src/images/test/TestLoadingScreen.png"), 0, 0));
	}


	/**
	 * Pre: none
	 * Post: Creates the colliders for the scene
	 */
	@Override
	public void createColliders() {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Pre: none
	 * Post: Creates the colliders for the scene
	 */
	@Override
	public void createBattleColliders() {
		// TODO Auto-generated method stub
		
	}

}
