package backend.battle;

public class BattleCharacter {
	private int bullets;
	private int maxBullets;
	private boolean armored;
	private boolean shot;
	int turn;
	public BattleCharacter(int maxBullets) {
		this.maxBullets = maxBullets;
		armored = false;
		shot = false;
	}
	
	public void tick() {
		armored = false;
		if (bullets > maxBullets) {
			bullets = maxBullets;
		}
	}
	
	public void reload() {
		bullets++;
	}
	
	public void defend() {
		armored = true;
	}
	
	public void shoot() {
		bullets--;
		shot = true;
	}
}
