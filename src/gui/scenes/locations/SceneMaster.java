package gui.scenes.locations;

import gui.scenes.Scene;

public class SceneMaster {
	public static Scene startScene, saloonScene, hotelScene, bankScene, gunfightScene, jailScene, railwayScene,
	saloonIScene, casinoScene, hotelIScene, bankIScene, gunfightIScene, jailIScene,railwayIScene, endScene;
	public static void createScenes() {
		System.out.print("createScenes()");

		railwayIScene = new BarScene(1); //railway station inside
		railwayScene = new RailwayScene(2); //railway station outside
		
		startScene = new StartScene(3); //start

		saloonIScene = new BarScene(4); //saloon inside
		saloonScene = new DesertScene(5); //saloon outside (need 2)***************

		bankIScene = new BarScene(6); //bank inside
		bankScene = new DesertScene(7); //bank outside

		jailIScene = new BarScene(8); //jail inside
		jailScene = new DesertScene(9); //jail outside

		hotelIScene = new BarScene(10); //hotel inside
		hotelScene = new DesertScene(11); //hotel outside

		casinoScene = new CasinoIScene(12); //saloon inside
		endScene = new DesertScene(13); //gunfight outside
		gunfightScene = new GunfightScene(14); //gunfight inside
	}
}