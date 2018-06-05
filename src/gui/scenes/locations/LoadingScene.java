package gui.scenes.locations;

import gui.DrawImageOnCanvas.ImageLoader;
import gui.scenes.Scene;
import images.ImageData;

public class LoadingScene extends Scene {

	@Override
	public void instantiate() {
		environment.add(new ImageData(ImageLoader.loadImage("src/images/test/TestLoadingScreen.png"), 0, 0));
	}
}
