/*
 * Villain.java
 * sets up the default villian class which extends human class
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package PresentationClasses;
/*
 * This is something we have to implement :(
 * - grayden
 */
import java.util.ArrayList;

public class Villain extends Human {
	String hatColor, mustacheColor, look;
	public int drunkenness, damselNum;
	ArrayList<Human> Damsels;
	public String path = "";

	/**
	 * pre: none
	 * post: villain human is constructed
	 */
	public Villain(String name, boolean male) {
		super(name, male);
		look = "mean";
		drunkenness = 0;
		//damselNum = 0;
	}

	/**
	 * pre: none
	 * post: Increase drunkenness level by 1
	 */
	public void drinkWhiskey() {
		drunkenness++;
	}
	
	/**
	 * pre: none
	 * post: returns the drunkenness of the villain
	 */
	public int returnDrunkenness() {
		return drunkenness;
	}

/**
 * pre: villain is not set up
 * post: variables are assigned to villain
 */
	public void TieUpDamsel(String name) {
		damselNum++;
		Human Damsel = new Human(name, false);
		Damsels.add(Damsel);
	}
/**
 * pre: villain is not set up
 * post: variables are assigned to villain
 */
	public void villainSetup(String name, String hatColor, String mustacheColor, String look, String sex, String horseName, String whiskyPreference, int damsels) {
		this.hatColor = hatColor; 
		this.mustacheColor = mustacheColor; 
		this.sex = sex; 
		this.horseName = horseName; 
		this.whiskeyPreference = whiskyPreference; 
		path = hatColor + mustacheColor + look;
		this.damselNum = damsels;
	}
}
