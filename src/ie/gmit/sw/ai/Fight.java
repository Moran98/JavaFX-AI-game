package ie.gmit.sw.ai;

public class Fight {
	
	double withinRange;
	CharacterTask c =  new CharacterTask();
	EnemyTask e = new EnemyTask();
	
	public void CheckDistance(int row, int col, int playerRow, int playerCol) {
		
		withinRange = Math.sqrt((playerRow - row) * (playerRow - row) + (playerCol - col) * (playerCol - col));
		withinRange = Math.round(withinRange);
		
		if(withinRange <= 5) {
			Attacking();
		}else {
			Healing();
		}
	}
	
	public void Attacking() {
		c.beingAttacked();
		e.beingAttacked();
	}
	
	public void Healing() {
		c.healing();
		e.healing();
	}

}
