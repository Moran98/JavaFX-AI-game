package ie.gmit.sw.ai;

import javafx.application.Application;
import net.sourceforge.jFuzzyLogic.FIS;

public class Runner {
	
	private static final String FILE = "fuzzy.fcl";
	
	public static void main(String[] args) {
		/*
		 * PLEASE READ CAREFULLY
		 * ---------------------
		 * If you need to load FCL functions to the application or
		 * train, configure and load a neural network, then it is 
		 * best to do all of this before loading the UI. Launching
		 * a UI in any language or framework and then starting a 
		 * long running task in the same thread is guaranteed to
		 * freeze the screen and crash the programme.
		 * 
		 * NB: you can assume that the JavaFX 15 API is already
		 * available and configured on the MODULE-PATH (NOT THE 
		 * CLASSPATH). 
		 */
		
		  //Add long-running initialisation instructions here.
		
		
		
		/*
		 * Launch the JavaFX UI only when all the long-running AI 
		 * configuration tasks have been completed. Use the arrow 
		 * keys to move the player character and the 'Z' key to 
		 * toggle the zoom in / out.
		 */
		Runner run = new Runner();
		run.loadFCL();
		Application.launch(GameWindow.class, args);
	}
	
	// Function called to load in a FCL file.
	public void loadFCL() {
		FIS fis = FIS.load(FILE, true);
		
		if(fis == null) {
			System.out.println("Error finding file " + FILE);
			return;
		}else {
			System.out.println("Successfully loaded in file " + FILE);
		}
	}
	
	public void loadNN() {
		// TODO
	}
}