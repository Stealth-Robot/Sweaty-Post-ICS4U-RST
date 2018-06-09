package gui.scenes.locations;

import gui.scenes.Scene;

public class SceneMaster {
	public static Scene startScene, saloonScene, hotelScene, bankScene, gunfightScene, jailScene, railwayScene,
	saloonIScene, casinoScene, hotelIScene, bankIScene, gunfightIScene, jailIScene,railwayIScene, endScene;
	public static void createScenes() {
		System.out.print("createScenes()");

		railwayIScene = new BarScene(); //railway station inside
		railwayScene = new TrainScene(); //railway station outside
		
		startScene = new StartScene(); //start

		saloonIScene = new CasinoIScene(); //saloon inside
		saloonScene = new DesertScene(); //saloon outside (need 2)***************

		bankIScene = new BarScene(); //bank inside
		bankScene = new DesertScene(); //bank outside

		jailIScene = new BarScene(); //jail inside
		jailScene = new DesertScene(); //jail outside

		hotelIScene = new BarScene(); //hotel inside
		hotelScene = new DesertScene(); //hotel outside

		casinoScene = new CasinoIScene(); //saloon inside
		endScene = new EndScene(); //gunfight outside
		gunfightScene = new GunfightScene(); //gunfight inside
	}
}