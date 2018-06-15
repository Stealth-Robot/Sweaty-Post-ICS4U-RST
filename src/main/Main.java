/*
 * Main.java
 * client code that runs the entire application
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package main;

import PresentationClasses.Human;
import PresentationClasses.Villain;
import PresentationClasses.WesternTown;
import gui.DrawImageOnCanvas;
import wildWest.WildWest;

//update
public class Main {
	public static boolean paused = false;
	public static int i = 0;

	public static DrawImageOnCanvas game;

	public static void main(String[] args) {
		villianSetup();
		game = new DrawImageOnCanvas();
		new WildWest(Slimy);
	}
	public static Villain Slimy;
	public static void villianSetup() {
		//The Dalton Brothers (Slimy, Sneaky, Shifty and Snitchy)
		//the Earps (Marshall Virgil, Wyatt, Morgan, and Doc Holliday)

				WesternTown sweatyPost = new WesternTown(); 
				sweatyPost.saloons = 2;
				sweatyPost.sheriffs = 1;
				sweatyPost.setTroublemakers(6);
/*Dalton Bros*/ Slimy = new Villain("Slimy", true);Villain Sneaky = new Villain("Sneaky", true);Villain Shifty = new Villain("Shifty", true);Villain Snitchy = new Villain("Snitchy", true);
/*The Earps*/	Villain Marshall_Virgil = new Villain("Marshall Virgil", true);Villain Wyatt = new Villain("Wyatt", true);Villain Morgan = new Villain("Morgan", true);Villain Doc_Holliday = new Villain("Doc Holliday", true);
				Slimy.villainSetup("Slimy", "Gold", "Red", "Male", "Beer Gut", "Jack Daniels","Blue");
				Sneaky.villainSetup("Sneaky", "Gold", "brown", "Male", "Shadow", "Beer","Blue");
				Shifty.villainSetup("Shifty", "brown", "none", "Male", "Bookie", "Whiskey","Blue");
				Snitchy.villainSetup("Snitchy", "sandy", "red", "Male", "buki", "Tequila","Blue");
				Marshall_Virgil.villainSetup("Marshall_Virgil", "black", "brown", "Male", "ja", "Wine","Blue");
				Wyatt.villainSetup("Wyatt", "Gold", "none", "Male", "Death Mere", "Water","Blue");
				Morgan.villainSetup("Morgan", "Brown", "red", "Male", "Horsearino", "Mixed Drinks","Blue");
				Doc_Holliday.villainSetup("Doc_Holliday", "sandy", "brown", "Male", "Beer Hater", "Jello Shots","Blue");
				Human mary = new Human("Mary", false);
				mary.sex = "female";
				mary.horseName = "Midnight";
				mary.whiskeyPreference = "Straight";
				mary.name = "Mary";
	}
}