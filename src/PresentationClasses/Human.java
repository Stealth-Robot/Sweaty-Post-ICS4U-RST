/*
 * Human.java
 * sets up default human class
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package PresentationClasses;
/*
 * This is something we have to implement :(
 * - grayden
 */
public class Human {
	public String name;
	public String sex;
	public String horseName;
	public String whiskeyPreference;
	
	/**
	 * Set the name and sex of the human
	 * @param name
	 * @param male (true is the human is male)
	 */
	public Human(String name, boolean male) {
		this.name = name;
		if (male) sex = "male";
		else sex = "female";
	}

	/**
	 * Returns the name of the human
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the human
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the horse name of the human
	 * @return horseName
	 */
	public String getHorseName() {
		return horseName;
	}
	
	/**
	 * Sets the horse name of the human
	 * @param horseName
	 */
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

/**
 * Returns the whiskey preference of the human
 * @return whiskeyPreference
 */
	public String getWhiskeyPreference() {
		return whiskeyPreference;
	}
	
/**
 * Sets the whiskeyPrefernce of the human
 * @param whiskeyPreference
 */
	public void setWiskeyPreference(String whiskeyPreference) {
		this.whiskeyPreference = whiskeyPreference;
	}

/**
 * Returns the sex of the human
 * @return sex
 */
	public String getSex() {
		return sex;
	}
	
/**
 * Sets the sex of the human
 * @param male
 */
	public void setSex(boolean male) {
		if (male) sex = "male";
		else sex = "female";
	}
	
/**
 * Returns true if the human is male
 * Returns false if the human is female
 * @return
 */
	public boolean isMale() {
		return sex.equals("male");
	}
	
	/**
	 * Returns true if the human is female
	 * Returns false if the human is male
	 * @return
	 */
	public boolean isFemale() {
		return !isMale();
	}
}