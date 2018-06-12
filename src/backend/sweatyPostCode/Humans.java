package backend.sweatyPostCode;

public class Humans { 
	int legs; 
	int arms; 
	int eyes; 
	int nose; 
	int mouth; 
	public String name; 
	public String sex; 
	public String horseName; 
	public String whiskeyPreference; 
	
	public Humans() { 
		legs = 2; 
		arms = 2; 
		eyes = 2; 
		nose = 1; 
		mouth = 1; 
	} 

	public String whatIsYourName() { 
		return name; 
	} 
} 