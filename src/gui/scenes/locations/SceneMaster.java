/*
 * SceneMaster.java
 * instantiates every scene
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes.locations;

import gui.scenes.Scene;

public class SceneMaster {
	public static Scene startScene, saloonScene, hotelScene, bankScene, gunfightScene, jailScene, railwayScene,
	saloonIScene, casinoScene, hotelIScene, bankIScene, gunfightIScene, jailIScene,railwayIScene, endScene, 
	 hotelRoomScene, jailCellScene1, jailCellScene2, jailCellScene3;
	public static void createScenes() {
		System.out.print("createScenes()");

		railwayIScene = new BarScene(1); //railway station inside
		railwayScene = new RailwayScene(2); //railway station outside
		
		startScene = new StartScene(3); //start

		saloonIScene = new BarScene(4); //saloon inside
		saloonScene = new DesertScene(5); //saloon outside (need 2)***************

		bankIScene = new BarScene(6); //bank inside
		bankScene = new DesertScene(7); //bank outside

		jailIScene = new JailScene(8); //jail inside
		jailScene = new DesertScene(9); //jail outside

		hotelIScene = new BarScene(10); //hotel inside
		hotelScene = new DesertScene(11); //hotel outside

		casinoScene = new CasinoIScene(12); //saloon inside
		endScene = new DesertScene(13); //gunfight outside
		gunfightScene = new GunfightScene(14); //gunfight inside

		jailCellScene1 = new JailCellScene(15); //gunfight inside
		jailCellScene2 = new JailCellScene(16); //gunfight inside
		jailCellScene3 = new JailCellScene(17); //gunfight inside
		hotelRoomScene = new HotelRoomScene(18); //gunfight inside
		hotelRoomScene = new HotelRoomScene(19); //gunfight inside
		hotelRoomScene = new HotelRoomScene(20); //gunfight inside
	}
}