package ie.gmit.sw.ai;

public class EnemyTask implements Command {
	
	private int health;
	private int damage;
	private GameWindow p1;
	
	// Constructor #1
	public EnemyTask() {
		super();
	}
	
	// Constructor #2
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

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	// Methods to determine the states of either
	// being attacked or healing.
    public void beingAttacked() {
    	health-=10;
    	System.out.println("Ghost taking DAMAGE");
    }
    
    public void healing() {
    	health+=10;
    	System.out.println("Ghost is HEALING");
    }
}
