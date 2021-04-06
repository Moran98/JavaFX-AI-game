package ie.gmit.sw.ai;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class LoadFCL {
	
	private static final String FILE = "res/fuzzy/fuzzy.fcl";
	
	// Function called to load in a FCL file.
	public double loadFCL(int ghost_damage, int ghost_health) {
		// Load in the file
		FIS fis = FIS.load(FILE, true);
		FunctionBlock fb = fis.getFunctionBlock("action");
		
		// Set the variables
		fis.setVariable("ghost_damage", ghost_damage);
		fis.setVariable("ghost_health", ghost_health);
		fis.evaluate();
		
		Variable dapping = fb.getVariable("victory");
		JFuzzyChart.get().chart(fis);
		JFuzzyChart.get().chart(dapping.getDefuzzifier(), "Dapping Level", true);
		
		// Error Handling
		if(fis == null) {
			System.out.println("Error finding file " + FILE);
		}else {
			System.out.println("Successfully loaded in file " + FILE);
		}

		return dapping.getValue();
	}

}
