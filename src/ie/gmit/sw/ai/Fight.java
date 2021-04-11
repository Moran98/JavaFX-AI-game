package ie.gmit.sw.ai;

public class Fight {
	
	double withinRange;
//	CharacterTask c =  new CharacterTask();
//	EnemyTask e = new EnemyTask();
	
	public void CheckDistance(int row, int col, int playerRow, int playerCol) {
		
		withinRange = Math.sqrt((playerRow - row) * (playerRow - row) + (playerCol - col) * (playerCol - col));
		withinRange = Math.round(withinRange);
		
		if(withinRange <= 1) {
			Attacking();
		}else {
			Healing();
		}
	}
	
	public void Attacking() {
//		c.beingAttacked();
//		e.beingAttacked();
		System.out.println("Attacking");
	}
	
	public void Fleeing() {
//		c.healing();
//		e.healing();
		System.out.println("Fleeing");
	}
	
	public void Healing() {
		System.out.println("Healing");
	}

}
