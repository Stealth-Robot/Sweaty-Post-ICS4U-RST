/*
 * BarScene.java
 * generates the inside scenes
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes.locations;

import java.awt.Image;
import backend.player.Player;
import gui.Vector2;
import gui.DrawImageOnCanvas.ImageLoader;
import gui.objects.RectangleCreator;
import gui.objects.colliders.Collider;
import gui.objects.colliders.SceneChangeColliderNoInteract;
import gui.objects.colliders.SpeechBattleCollider;
import gui.objects.colliders.SpeechCollider;
import gui.objects.colliders.dialog.BankCollider;
import gui.objects.colliders.dialog.BartenderCollider;
import gui.objects.colliders.dialog.HotelCollider;
import gui.objects.colliders.dialog.JailCollider;
import gui.objects.colliders.dialog.RailwayCollider;
import gui.scenes.Scene;
import images.ImageData;
import main.Main;

public class BarScene extends Scene {

	public BarScene(int identifier) {
		super(identifier);
		//System.out.print(identifier + ",");
	}

	@Override
	public void createEnvironment() {
		Image testImage = ImageLoader.loadImage("src/images/sprites/environments/desert/Desert.png");
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 6; y++) {
				if (y > 4 || y <= 3) {
					int worldGen = (int) (18 * Math.random() + 1);
					switch (worldGen) // switches are used to set the tile based
										// on a random number (1-6)
					{
					case 1:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
						break;
					case 2:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
						break;
					case 3:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
						break;
					case 4:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
						break;
					case 5:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor2.png");
						break;
					default:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor.png");
						break;
					}
					if ((y == 2 && x == 1 || y == 1 && x == 3 || y == 2 && x == 6) && identifier != 8) {
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/Table.png");
					}
				} else {
					int railGen = (int) (4 * Math.random() + 1);
					switch (railGen) // switches are used to set the tile based
										// on a random number (1-6)
					{
					case 1:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarMessy.png");
						break;
					default:
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/Bar.png");
						break;
					}
					if (x == 7)
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarCorner.png");
					if (x == 8)
						testImage = ImageLoader.loadImage("src/images/sprites/environments/inside/BarFloor.png");
					if (x == 4)
						testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarInteract.png");
				}
				if (x == 4 && y == 0)
					testImage = ImageLoader.loadImage("src/images/sprites/interactables/BarExit.png");
				environment.add(new ImageData(testImage, x, y));
			}
		}
		environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/NPCMale.png"), 4, 5));

		if (identifier == 8) {
			environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/BarExitUp.png"), 1, 5));
			environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/BarExitUp.png"), 3, 5));
			environment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/BarExitUp.png"), 5, 5));
		}
	}

	@Override
	public void createColliders() {
		Image testImage = ImageLoader.loadImage("src/images/sprites/Enemy.png");
		addCollider(new Collider(RectangleCreator.colliderRectangle(0, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(1, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(2, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(3, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(4, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(5, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(6, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(7, 5)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(1, 2)));
		addCollider(new Collider(RectangleCreator.dimensionalRectangle(0.95, 0.95, 3, 1)));
		addCollider(new Collider(RectangleCreator.colliderRectangle(6, 2)));
		if (identifier == 1) {
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(4, -0.95),
					SceneMaster.railwayScene, new Vector2(4, 0.5), Player.Movement.NORTH, Player.Movement.SOUTH));
		}
			
		if (identifier == 4) {
			addCollider(new BartenderCollider(RectangleCreator.colliderRectangle(4, 4)));
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(4, -0.95),
					SceneMaster.saloonScene, new Vector2(6, 2.5), Player.Movement.NORTH, Player.Movement.SOUTH));
		}
		if (identifier == 6) {
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(4, -0.95),
					SceneMaster.bankScene, new Vector2(6, 2.5), Player.Movement.NORTH, Player.Movement.SOUTH));
			addCollider(new BankCollider(RectangleCreator.colliderRectangle(4, 4)));
		}
			
		if (identifier == 8)
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(4, -0.95),
					SceneMaster.jailScene, new Vector2(6, 2.5), Player.Movement.NORTH, Player.Movement.SOUTH));
		if (identifier == 10) {
			addCollider(new SceneChangeColliderNoInteract(RectangleCreator.colliderRectangle(4, -0.95),
					SceneMaster.hotelScene, new Vector2(6, 2.5), Player.Movement.NORTH, Player.Movement.SOUTH));
			addCollider(new HotelCollider(RectangleCreator.colliderRectangle(4, 4)));
		}
	       if(identifier==10) {
		        testImage = ImageLoader.loadImage("src/images/sprites/EnemyGreyBlue.png");
		        if(Main.Beach_Girl.ready) {
		        	postEnvironment.add(new ImageData(testImage,8,0));
		        	addCollider(new Collider(RectangleCreator.colliderRectangle(8,0)));
		        	postEnvironment.add(new ImageData(ImageLoader.loadImage("src/images/sprites/interactables/FloorInteract.png"),8,1));
		        }
	       }
		
	}

	@Override
	public void createBattleColliders() {
		if(identifier == 1) {
			addBattleCollider(new RailwayCollider(RectangleCreator.colliderRectangle(4, 4)));
		}
		if(identifier==10)
			addBattleCollider(new SpeechBattleCollider(RectangleCreator.colliderRectangle(8, 1), Main.Beach_Girl,"Hey handsome ;) wanna wrastle?","HEY! Don't touch that!"));
	}
}