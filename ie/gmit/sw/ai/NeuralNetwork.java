package ie.gmit.sw.ai;

public class NeuralNetwork {
	
	private double[][] data = { //Health, Sword, Enemies
			{2,0,0},{2,0,1},{2,1,0},{2,1,1},{0,0,0},
	        {1,0,0},{1,0,1},{1,1,0},{1,1,1}
	};

	   
	private double[][] expected = { //Attack,Run
	        {1.0,0.0},{1.0,0.0},{0.0,1.0},{0,0,1.0},{1.0,0.0},
	        {1.0,0.0},{1.0,0.0},{1.0,0.0},{0.0,1.0}
	};

}
