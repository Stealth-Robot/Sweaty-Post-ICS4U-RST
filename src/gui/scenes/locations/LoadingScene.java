package gui.scenes.locations;

import gui.DrawImageOnCanvas.ImageLoader;
import gui.scenes.Scene;
import images.ImageData;

public class LoadingScene extends Scene {

	public LoadingScene(int identifier) {
		super(identifier);
		System.out.print(identifier + ",");
	}

	@Override
	public void createEnvironment() {
		environment.add(new ImageData(ImageLoader.loadImage("src/images/test/TestLoadingScreen.png"), 0, 0));
	}

	@Override
	public void createColliders() {
		// TODO Auto-generated method stub
		
	}

}
