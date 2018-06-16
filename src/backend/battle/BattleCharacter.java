/*
 * BattleAI.java
 * the code that runs the wild west game
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package backend.battle;

public class BattleCharacter {
	public int bullets;
	private int maxBullets;
	public boolean armored;
	public boolean shot;
	int turn;

	/**
	 * Pre: Called when the battle first starts, 
	 * post: a new battle character is created and that battle character's maximum ammo is chosen
	 * @param maxBullets
	 */
	public BattleCharacter(int maxBullets) {
		this.maxBullets = maxBullets;
		armored = false;
		shot = false;
	}

	/**
	 * pre: Called after the character makes their choice
	 * post: shoots
	 */
	public boolean tick(BattleCharacter enemy) {
		if (bullets > maxBullets) {
			bullets = maxBullets;
		} 
		return shooting(enemy);
	}

	/**
	 * pre: Called at the end of each character's turn
	 * post: resets armored and shot to false
	 */
	public void resetTurn() {
		armored = false;
		shot = false;
	}

	/**
	 * pre: Calls the action chosen to perform
	 * post: gives choice (1 = shoot, 2 = reload, 3 = defend)
	 */
	public void actions(int choice) {
		if (choice == 1) shoot();
		if (choice == 2) reload();
		if (choice == 3) defend();
	}

	/**
	 * pre: reload is chosen
	 * post: bullets increase by 1
	 */
	private void reload() {
		bullets++;
	}
	/**
	 * pre: defend is chosen
	 * post: player becomes armored
	 */
	private void defend() {
		armored = true;
	}
	/**
	 * pre: shoot is selected
	 * post: shoot becomes true
	 */
	private void shoot() {
		if (bullets > 0) {
			bullets--;
			shot = true;
		}
	}

	/**
	 * pre: Calls the getShot function from the enemy battleCharacter
	 * post: returns if shooting or not
	 */
	public boolean shooting(BattleCharacter enemy) {
		if (shot) return (enemy.getShot());
		else return false;
	}

	/**
	 * pre: none
	 * post: determines if the bullet connects
	 */
	public boolean getShot() {
		if (shot) return false;
		if (armored) return false;
		else return true;
	}
}
