/*
 * WesternTown.java
 * sets up default town settings
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package PresentationClasses;
/*
 * This is something we have to implement :(
 * - grayden
 */
public class WesternTown {
	private int stables, saloon, sherrifs, troublemakers, time;
	private String location;
	public int saloons;
	public int sheriffs;

	/**
	 * 
	 */
	public WesternTown()
	{
		stables = 3;
		location = "Western America";
		time = 1850;
	}
	
	/**
	 * Returns the stables within the WesternTown
	 * @return stables
	 */
	public int getStables() {
		return stables;
	}
	
	/**
	 * Sets the stables within the WesternTown class
	 * @param stables
	 */
	public void setStables(int stables) {
		this.stables = stables;
	}
	
	/**
	 * Returns the saloons within the WesternTown
	 * @return saloon
	 */
	public int getSaloon() {
		return saloon;
	}
	
	/**
	 * Sets the saloons within the WesternTown class
	 * @param saloon
	 */
	public void setSaloon(int saloon) {
		this.saloon = saloon;
	}
	
	/**
	 * Returns the sherrifs within the WesternTown
	 * @return sherrifs
	 */
	public int getSherrifs() {
		return sherrifs;
	}
	
	/**
	 * Sets the sherrifs within the WesternTown class
	 * @param sherrifs
	 */
	public void setSherrifs(int sherrifs) {
		this.sherrifs = sherrifs;
	}
	
	/**
	 * Returns the troublemakers within the WesternTown
	 * @return troublemakers
	 */
	public int getTroublemakers() {
		return troublemakers;
	}
	
	/**
	 * Sets the troublemakers within the WesternTown class
	 * @param troublemakers
	 */
	public void setTroublemaker(int troublemakers) {
		this.setTroublemakers(troublemakers);
	}
	
	/**
	 * Returns the location within the WesternTown
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the Location within the WesternTown class
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public void setTroublemakers(int troublemakers) {
		this.troublemakers = troublemakers;
	}

}
