package backend.sweatyPostCode;

public class Villains extends Humans 
{ 
public String mustacheColor; 
public String hatColor; 
public String look; 
public int drunkenness; 
public int numberOfDamsels; 
Humans damsel; 
	public Villains() 
	{ 
		look = "Mean"; 
		drunkenness = 0; 
		numberOfDamsels = 0; 
	}
	public void drinkWhiskey() 
	{ 
		drunkenness ++; 
	}
	public int howDrunkAmI() 
	{ 
		return drunkenness; 
	}
	public void tieUpDamsel (Humans damsel) 
	{ 
		this.damsel = damsel; 
		numberOfDamsels++; 
		System.out.println("The Villain has tied up " + damsel.whatIsYourName()); 
	} 
} 