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
	public static Villain Slimy,Sneaky,Shifty,Snitchy,Marshall_Virgil,Wyatt,Morgan,Doc_Holliday,tutorial;
	public static boolean paused = false;
	public static int i = 0;

	public static DrawImageOnCanvas game;

	public static void main(String[] args) {
		villianSetup();
		System.out.println(tutorial);

		game = new DrawImageOnCanvas();
		new WildWest(Slimy);
	}

	/**
	 * pre: none
	 * post: all villains are instantiated
	 */
	public static void villianSetup() {
		// The Dalton Brothers (Slimy, Sneaky, Shifty and Snitchy)
		// the Earps (Marshall Virgil, Wyatt, Morgan, and Doc Holliday)

		WesternTown sweatyPost = new WesternTown(); sweatyPost.saloons = 2; sweatyPost.sheriffs = 1; sweatyPost.setTroublemakers(6);
	/* Dalton Bros */ 
		Slimy = new Villain("Slimy", true);
		Sneaky = new Villain("Sneaky", true);
		Shifty = new Villain("Shifty", true);
		Snitchy = new Villain("Snitchy", true);
		tutorial = new Villain("Bank Robber", true);
	/* The Earps */ 
		Marshall_Virgil = new Villain("Marshall Virgil", true);
		Wyatt = new Villain("Wyatt", true);
		Morgan = new Villain("Morgan", true);
		Doc_Holliday = new Villain("Doc Holliday", true);

		tutorial.villainSetup       ("Bank Robber",     "Gold",  "Red",   "Blue", "Male", "Beer Gut",   "Jack Daniels");
		Slimy.villainSetup          ("Slimy",           "Gold",  "Red",   "Blue", "Male", "Beer Gut",   "Jack Daniels");
		Sneaky.villainSetup         ("Sneaky",          "Gold",  "brown", "Blue", "Male", "Shadow",     "Beer");
		Shifty.villainSetup         ("Shifty",          "brown", "none",  "Blue", "Male", "Bookie",     "Whiskey");
		Snitchy.villainSetup        ("Snitchy",         "sandy", "red",   "Blue", "Male", "buki",       "Tequila");
		Marshall_Virgil.villainSetup("Marshall Virgil", "black", "brown", "Blue", "Male", "ja",         "Wine");
		Wyatt.villainSetup          ("Wyatt",           "Gold",  "none",  "Blue", "Male", "Death Mere", "Water");
		Morgan.villainSetup         ("Morgan",          "Brown", "red",   "Blue", "Male", "Horsearino", "Mixed Drinks");
		Doc_Holliday.villainSetup   ("Doc Holliday",    "sandy", "brown", "Blue", "Male", "Beer Hater", "Jello Shots");
		Human mary = new Human("Mary", false);
		mary.sex = "female";
		mary.horseName = "Midnight";
		mary.whiskeyPreference = "Straight";
		mary.name = "Mary";
	}
}