package gui.scenes.locations;

import gui.scenes.Scene;

public class SceneMaster {
	public static Scene startScene, saloonScene, hotelScene, bankScene, gunfightScene, jailScene, railwayScene,
						saloonIScene, hotelIScene, bankIScene, gunfightIScene, jailIScene,railwayIScene;
	public static void createScenes() {
		System.out.print("createScenes()");
		startScene = new StartScene(); //start
		saloonScene = new DesertScene(); //saloon outside (need 2)***************
		hotelScene = new DesertScene(); //hotel outside
		bankScene = new DesertScene(); //bank outside
		gunfightScene = new DesertScene(); //gunfight outside
		jailScene = new DesertScene(); //jail outside
		railwayScene = new TrainScene(); //railway station outside
		saloonIScene = new CasinoIScene(); //saloon inside
		hotelIScene = new BarScene(); //hotel inside
		bankIScene = new BarScene(); //bank inside
		gunfightIScene = new DesertScene(); //gunfight inside
		jailIScene = new BarScene(); //jail inside
		railwayIScene = new BarScene(); //railway station inside
	}
}
