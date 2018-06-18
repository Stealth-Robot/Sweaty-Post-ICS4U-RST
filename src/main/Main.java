/*
 * Main.java
 * client code that runs the entire application
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * ICS4U
 * June 2018
 */
package main;

import PresentationClasses.Villain;
import PresentationClasses.WesternTown;
import gui.DrawImageOnCanvas;
import wildWest.WildWest;

//update
public class Main {
	public static Villain Slimy,Sneaky,Shifty,Snitchy,Marshall_Virgil,Wyatt,Morgan,Doc_Holliday,tutorial,Burrito_Boi,Bepsi_Boi,Surfer_Boi,Beach_Girl;
	public static boolean paused = false;
	public static int i = 0;

	public static DrawImageOnCanvas game;

	public static void main(String[] args) {
		villianSetup();
		System.out.println(tutorial);

		game = new DrawImageOnCanvas();
		new WildWest(tutorial);
	}

	/**
	 * pre: none
	 * post: all villains are instantiated
	 */
	public static void villianSetup() {
		// The Dalton Brothers (Slimy, Sneaky, Shifty and Snitchy)
		// the Earps (Marshall Virgil, Wyatt, Morgan, and Doc Holliday)

		WesternTown sweatyPost = new WesternTown(); sweatyPost.saloons = 2; sweatyPost.sheriffs = 1; sweatyPost.setTroublemakers(7);
		tutorial = new Villain("Bank Robber", true);
	/* Dalton Bros */ 
		Slimy = new Villain("Slimy", true);
		Sneaky = new Villain("Sneaky", true);
		Shifty = new Villain("Shifty", true);
		Snitchy = new Villain("Snitchy", true);
	/* The Earps */ 
		Marshall_Virgil = new Villain("Marshall Virgil", true);
		Wyatt = new Villain("Wyatt", true);
		Morgan = new Villain("Morgan", true);
		Doc_Holliday = new Villain("Doc Holliday", true);
	/* Bonus Bois */ 
		Burrito_Boi = new Villain("Burrito Boi", true);
		Bepsi_Boi = new Villain("Bepsi Boi", true);
		Surfer_Boi = new Villain("Surfer Boi", true);
		Beach_Girl = new Villain("Beach Girl", false);

		tutorial.villainSetup       ("Bank Robber",     "Yellow", "None",  "Blue",   "Male",   "Beer Gut",       "Jack Daniels",1);
		Slimy.villainSetup          ("Slimy",           "Yellow", "None",  "Blue",   "Male",   "Beer Gut",       "Jack Daniels",1);
		Sneaky.villainSetup         ("Sneaky",          "Silver", "Red",   "Navy",   "Male",   "Shadow",         "Beer",1);
		Shifty.villainSetup         ("Shifty",          "Grey",   "None",  "Yellow", "Male",   "Bookie",         "Whiskey",1);
		Snitchy.villainSetup        ("Snitchy",         "Grey",   "Brown", "Green",  "Male",   "buki",           "Tequila",1);
		Marshall_Virgil.villainSetup("Marshall Virgil", "Gold",   "Red",   "Blue",   "Male",   "ja",             "Wine",1);
		Wyatt.villainSetup          ("Wyatt",           "Gold",   "None",  "Navy",   "Male",   "Death Mere",     "Water",1);
		Morgan.villainSetup         ("Morgan",          "Yellow", "Brown", "Yellow", "Male",   "Horsearino",     "Mixed Drinks",1);
		Doc_Holliday.villainSetup   ("Doc Holliday",    "Silver", "None",  "Green",  "Male",   "Beer Hater",     "Jello Shots",1);
		Burrito_Boi.villainSetup    ("Burrito Boi",     "Burr",   "ito",   "Boi",    "Male",   "Condament King", "Tomato Juice",1);
		Bepsi_Boi.villainSetup      ("Bepsi Boi",       "Bep",    "si",    "Boi",    "Male",   "Bottle Truck",   "Diet Coke",1);
		Surfer_Boi.villainSetup     ("Surfer Boi",      "Surf",   "er",    "Boi",    "Male",   "Surf Board",     "Salt Water",1);
		Beach_Girl.villainSetup     ("Beach Girl",      "Bea",    "ch",    "Boi",    "Female", "Surfer Boi",     "Beach Cocktail",1);
	}
}