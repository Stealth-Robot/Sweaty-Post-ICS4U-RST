package backend.battle;

public class BattleAI {
	public int choice() {
	int temp;
		do 
			temp = ((int)(Math.random() * 3) + 1);
		while (temp != 4);
		return temp;
	}
}
