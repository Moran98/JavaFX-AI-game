package ie.gmit.sw.ai;

public class EnemyTask {
	
	private int health;
	private int damage;
	private GameWindow p1;
	private LoadNN nn = new LoadNN();
	String action;
	private int NetworkHealth;
	
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
	public boolean isAlive() {
		if(health >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	// Process depending on the range between ghost and player
	public String process(int withinRange) throws Exception {
		
		int output = 0;
		
		if(health >=70) {
			NetworkHealth=2;
		} else if(health >= 40 && health <70) {
			NetworkHealth=1;
		} else {
			NetworkHealth=0;
		}
		
        System.out.println(NetworkHealth + "  " + damage + "  " + withinRange);

		
		double[] input = {NetworkHealth, damage, withinRange};
		output = new LoadNN().run(input);
		
		switch(output) {
			case 1: 
				action = "Attack";
				break;
			case 2:
				action = "Fleeing";
				break;
		}
		
		return action;
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