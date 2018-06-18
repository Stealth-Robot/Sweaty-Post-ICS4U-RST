/*
 * Main.java
 * client code that runs the entire application
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * ICS4U
 * June 2018
 */
package main;

import java.util.ArrayList;

import PresentationClasses.Villain;
import PresentationClasses.WesternTown;
import dialog.DialogCreator;
import gui.DrawImageOnCanvas;
import wildWest.WildWest;

//update
public class Main {
	public static Villain Slimy,Sneaky,Shifty,Snitchy,Marshall_Virgil,Wyatt,Morgan,Doc_Holliday,tutorial,Burrito_Boi,Bepsi_Boi,Surfer_Boi,Beach_Girl;
	public static boolean paused = false;
	public static int i = 0;
	public static int gameProgress = 0;
	public static DrawImageOnCanvas game;
	public static Villain[] enemies;
	public static void main(String[] args) {
		villianSetup();

		game = new DrawImageOnCanvas();
		DialogCreator.createDialog("Totorial", intro(), 0);
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
		enemies = new Villain[] {Slimy,Sneaky,Shifty,Snitchy,Marshall_Virgil,Wyatt,Morgan,Doc_Holliday,Burrito_Boi,Bepsi_Boi,Surfer_Boi,Beach_Girl};
		tutorial.villainSetup       ("Bank Robber",     "Yellow", "None",  "Blue",   "Male",   "Beer Gut",       "Jack Daniels",    1, false);
		Slimy.villainSetup          ("Slimy",           "Yellow", "None",  "Blue",   "Male",   "Beer Gut",       "Jack Daniels",   10, false);
		Sneaky.villainSetup         ("Sneaky",          "Silver", "Red",   "Navy",   "Male",   "Shadow",         "Beer",           16, false);
		Shifty.villainSetup         ("Shifty",          "Grey",   "None",  "Yellow", "Male",   "Bookie",         "Whiskey",         9, false);
		Snitchy.villainSetup        ("Snitchy",         "Grey",   "Brown", "Green",  "Male",   "buki",           "Tequila",        11, false);
		Marshall_Virgil.villainSetup("Marshall Virgil", "Gold",   "Red",   "Blue",   "Male",   "ja",             "Wine",           12, false);
		Wyatt.villainSetup          ("Wyatt",           "Gold",   "None",  "Navy",   "Male",   "Death Mere",     "Water",          12, false);
		Morgan.villainSetup         ("Morgan",          "Yellow", "Brown", "Yellow", "Male",   "Horsearino",     "Mixed Drinks",   13, false);
		Doc_Holliday.villainSetup   ("Doc Holliday",    "Silver", "None",  "Green",  "Male",   "Beer Hater",     "Jello Shots",    14, false);
		Burrito_Boi.villainSetup    ("Burrito Boi",     "Burr",   "ito",   "Boi",    "Male",   "Condament King", "Tomato Juice",   20, true);
		Bepsi_Boi.villainSetup      ("Bepsi Boi",       "Bep",    "si",    "Boi",    "Male",   "Bottle Truck",   "Diet Coke",      20, true);
		Surfer_Boi.villainSetup     ("Surfer Boi",      "Surf",   "er",    "Boi",    "Male",   "Surf Board",     "Salt Water",     20, true);
		Beach_Girl.villainSetup     ("Beach Girl",      "Bea",    "ch",    "Girl",   "Female", "Surfer Boi",     "Beach Cocktail", 20, true);
	}

	public static String intro() {
		return("Welcome to the town of Sweaty Post! The goal of the game is to defeat the 8 main villians and collect as many damsels as "
				+ "possible \nbefore you do so. Damsels are your score, everytime you defeat a villian you get damsels. You can check "
				+ "your damsels in the Hotel. \nIf you die, you lose all of your damsels and you respawn at the hotel. Movement is the "
				+ "WASD keys and to interact you double click \"e\". \nYou can interact on any tile that has a red box. Test this "
				+ "newfound knowledge with the Station Master of the train Station. He will \nreward you with damsels! \n\nWhen you "
				+ "fight an enemy it starts a game of wild west. The rules of the game are simple: shoot your opponent and don't get "
				+ "shot.\nYou have three choices each turn (Shoot, Reload, or Dodge) \nShoot - if you have bullets, you shoot the enemy"
				+ " (if he blocks or also shoots nothing hallens) \nReload - you add one bullet to your revolver \nDodge - you block "
				+ "any bollets shot at you\n\nYour goal is to clear out the Dalton Bros and the Earps. To do this you must battle all "
				+ "eight of them. Once you have battled all eight \nyou will have won the game and you can be happy. There are "
				+ "also 4 bonus charictors which give more damsels than the normal \nenemies. Killing them is a great way to boost your "
				+ "score!\n\nThere are three groups of enemies:\nThe Daltons (Slimy, Sneaky, Shifty, Snitchy): You meet these guys not "
				+ "long after leaving the railway station, they just pulled a \n          jailbreak and broke the Earps out of jail. They are "
				+ "mean and insulting but not very bright. You must battle these four if you \n          want to win the game.\nThe Earps: ("
				+ "Marshall Virgil, Wyatt, Morgan, Doc Holliday): They just escaped from the jail. They are busy fleeing and you can "
				+ "catch \n          them as they run away in the very last scene. They are as smart as they are evil... although not very "
				+ "good at playig wild wild \n          west honestly.\nThe Bonus Bois (Burrito Boi, Bepsi Boi, Surfer Boi, Beach Girl): These"
				+ "shifty and weird guys and gals are just in town to make \n          trouble. The mayor has asked you to deal with them if you "
				+ "have time after beating the Daltons or the Earps. Unfortunatly once \n          you beat the Daltons and the Earps, you have to "
				+ "quickly run off to Stinky Foot, the neighboring town to deal with more Baddies. \n         Therefore, I suggest you fight the "
				+ "Bonus Bois before beating the last of the core 8 baddies in order to have time left!\n\nGood Luck young Adventurer and dont "
				+ "forget: If you are havng trouble, try being better at the game!");
	}
}