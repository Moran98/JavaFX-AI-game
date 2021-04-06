package ie.gmit.sw.ai;

public class EnemyTask {
	
	private int health;
	private int damage;
	private GameWindow p1;
	
	// Constructor 
	public EnemyTask(int health, int damage, GameWindow p1) {
		this.health = health;
		this.damage = damage;
		this.p1 = p1;
	}
	
	// getters
	public int getHealth() {
		return health;
	}
	
	// setters
	public void setHealth(int health) {
		this.health = health;
	}
	
	// boolean to check the state of the ghost (alive/dead)
	public boolean isDead() {
		if(health > 0) {
			return true;
		} else {
			return false;
		}
	}
}
