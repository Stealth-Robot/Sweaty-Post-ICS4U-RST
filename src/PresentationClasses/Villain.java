package PresentationClasses;
/*
 * This is something we have to implement :(
 * - grayden
 */
import java.util.ArrayList;

public class Villain extends Human {
	String mustachColour, hatColour, look;
	int drunkenness, numberOfDamsels;
	ArrayList<Human> Damsels;

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
}
