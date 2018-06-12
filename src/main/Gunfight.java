package main;

import backend.sweatyPostCode.Humans;
import backend.sweatyPostCode.Villains;
import backend.sweatyPostCode.WesternTown;
import dialog.DialogCreator;
import gui.DrawImageOnCanvas;


//update
public class Gunfight {
	public static boolean paused = false;
	public static int i = 0;
	static String intro;
	
	public static DrawImageOnCanvas game;
	public static void main(String[] args) {
		game = new DrawImageOnCanvas();
		intro();
		requiredCode();
		//new WildWest();
	}

	public static void intro () {
		intro = "Welcome to Sweaty Post!";
		//DialogCreator.createDialog("The Welcome Wagon of Sweaty Post", intro);
	}
	
	public static void requiredCode() {
        //required code I need to put somewhere
		WesternTown sweatyPost = new WesternTown(); 
		sweatyPost.saloons = 2; 
		sweatyPost.sheriffs = 1; 
		sweatyPost.troublemakers = 5;
		Villains maurice = new Villains();
		maurice.hatColor = "black"; 
		maurice.mustacheColor = "red"; 
		maurice.sex = "Male"; 
		maurice.horseName = "Beer Gut"; 
		maurice.whiskeyPreference = "Jack Daniels"; 
		Humans mary = new Humans(); 
		mary.sex = "female"; 
		mary.horseName = "Midnight"; 
		mary.whiskeyPreference = "Straight"; 
		mary.name = "Mary"; 
		maurice.drinkWhiskey();
		System.out.println(maurice.howDrunkAmI());
		maurice.tieUpDamsel(mary); 
	}
}