package gui.scenes;

import gui.StartScene;

public class SceneMaster {
	public static Scene startScene, hideoutScene, hotelScene, jailScene, shopScene, desertScene, desertScene2,
			desertScene3, desertScene4, desertScene5, desertScene6, barScene, casinoScene, trainScene, casinoIScene;

	public static void createScenes() {
		startScene = new StartScene();
		desertScene = new DesertScene();
		desertScene2 = new DesertScene();
		desertScene3 = new DesertScene();
		desertScene4 = new DesertScene();
		desertScene5 = new DesertScene();
		desertScene6 = new DesertScene();
		casinoScene = new DesertScene();
		trainScene = new TrainScene();
		hideoutScene = new DesertScene();
		barScene = new BarScene();
		hotelScene = new BarScene();
		shopScene = new BarScene();
		jailScene = new BarScene();
		casinoIScene = new CasinoIScene();
	}
}
