package backend.battle;

public class BattleCharacter {
	public int bullets;
	private int maxBullets;
	private boolean armored;
	private boolean shot;
	int turn;

	/**
	 * Called when the battle first starts, a new battle character is created
	 * and that battle character's maximum ammo is chosen
	 * @param maxBullets
	 */
	public BattleCharacter(int maxBullets) {
		this.maxBullets = maxBullets;
		armored = false;
		shot = false;
	}

	/**
	 * Called after the chracter makes their choice
	 * @param enemy
	 */
	public boolean tick(BattleCharacter enemy) {
		if (bullets > maxBullets) {
			bullets = maxBullets;
		} 
		return shooting(enemy);
	}

	/**
	 * Called at the end of each character's turn
	 */
	public void resetTurn() {
		armored = false;
		shot = false;
	}

	/**
	 * Calls the action chosen to perform
	 * @param choice (1 = shoot, 2 = reload, 3 = defend)
	 */
	public void actions(int choice) {
		if (choice == 1) shoot();
		if (choice == 2) reload();
		if (choice == 3) defend();
	}

	private void reload() {
		bullets++;
	}
	private void defend() {
		armored = true;
	}
	private void shoot() {
		if (bullets > 0) {
			bullets--;
			shot = true;
		}
	}

	/**
	 * Calls the getShot function from the enemy battleCharacter
	 * @param enemy
	 * @return
	 */
	public boolean shooting(BattleCharacter enemy) {
		if (shot) return (enemy.getShot());
		else return false;
	}

	/**
	 * Called from another battleCharacter
	 * @return
	 */
	public boolean getShot() {
		if (shot) return false;
		if (armored) return false;
		else return true;
	}
}
