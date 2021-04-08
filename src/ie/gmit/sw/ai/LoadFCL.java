package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class LoadFCL {
	
	private static LoadFCL instance;
	private FIS fis;
	private static final String FILE = "fcl/fuzzy.fcl";
	private FunctionBlock fb;
	
	// Load in the FCL file
	public LoadFCL() {
		fis = FIS.load(FILE, true);
		fb = fis.getFunctionBlock("action");
		
		// Error Handling
		if(fis == null) {
			System.out.println("Error finding file " + FILE);
		}else {
			System.out.println("Successfully loaded in file " + FILE);
		}
	}
	
	// Retrieve instance of class
	public static LoadFCL getInstance() {
		if(instance == null) {
			instance = new LoadFCL();
		}
		return instance;
	}
	
	// Function called to load in a FCL file.
	public double getActions(int ghost_health, int player_health, int player_damage) {
	
		// Set the variables
		fis.setVariable("ghost_health", ghost_health);
		fis.setVariable("player_health", player_health);
		fis.setVariable("player_damage", player_damage);

		fis.evaluate();
		
		Variable dapping = fb.getVariable("victory");
		JFuzzyChart.get().chart(fis);
		JFuzzyChart.get().chart(dapping.getDefuzzifier(), "Dapping Level", true);
		
		System.out.println("Ghost Health:" + ghost_health + "Player Damage" +player_damage + "Player Health" + player_health);

		return dapping.getValue();
	}

}
