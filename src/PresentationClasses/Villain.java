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
	String mustachColour, hatColour, look;
	int drunkenness, numberOfDamsels;
	public String path;
	ArrayList<Human> Damsels;
	public String hatColor;
	public String mustacheColor;

	/**
	 * @param name
	 * @param male
	 */
	public Villain(String name, boolean male) {
		super(name, male);
		look = "mean";
		drunkenness = 0;
		numberOfDamsels = 0;
	}

	/**
	 * Increase drunkenness level by 1
	 */
	public void drinkWhiskey() {
		drunkenness++;
	}
	
	/**
	 * Returns the drunkenness of the villain
	 * @return drunkenness
	 */
	public int returnDrunkenness() {
		return drunkenness;
	}
	
	public void TieUpDamsel(String name) {
		numberOfDamsels++;
		Human Damsel = new Human(name, false);
		Damsels.add(Damsel);
	}

	public void villainSetup(String name, String hatColor, String mustacheColor, String sex, String horseName, String whiskyPreference, String look) {
		this.hatColor = hatColor; 
		this.mustacheColor = mustacheColor; 
		this.sex = sex; 
		this.horseName = horseName; 
		this.whiskeyPreference = whiskyPreference; 
		this.path = hatColor + mustacheColor + look;
	}
}
