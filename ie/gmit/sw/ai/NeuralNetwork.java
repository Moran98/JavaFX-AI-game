package ie.gmit.sw.ai;

import org.encog.Encog;
import org.encog.engine.network.activation.ActivationReLU;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;


public class NeuralNetwork {
	
	/*
	 *  Inputs
	 *  -------------
	 *  1) Health (2 = Healthy, 1 = Minor Injuries, 0 = Serious Injuries)
	 *  2) Has a Sword (1 = yes, 0 = no)
	 *  3) Has a Gun (1 = yes, 0 = no)
	 *  4) Number of Enemies (This value may need to be normalized)
	 *  
	 *  Outputs
	 *  -------------
	 *  1) Panic
	 *  2) Attack
	 *  3) Hide
	 *  4) Run
	 */
	
	private final double[][] data = { //Health, Sword, Enemies
			{2,0,0},{2,0,1},{2,1,0},{2,1,1},{0,0,0},
	        {1,0,0},{1,0,1},{1,1,0},{1,1,1}
	};

	   
	private final double[][] expected = { //Attack,Run
	        {1.0,0.0},{1.0,0.0},{0.0,1.0},{0,0,1.0},{1.0,0.0},
	        {1.0,0.0},{1.0,0.0},{1.0,0.0},{0.0,1.0}
	};
	
	// Creating the Neural Network, this code has been adapted from the NetEncog Lab.
	BasicNetwork Network(){
		// create a neural network, without using a factory.
		BasicNetwork network = new BasicNetwork();
		// Adding in the layers. Two layers will follow the Sigmoid pattern.
		network.addLayer(new BasicLayer(null,true,2));
		network.addLayer(new BasicLayer(new ActivationSigmoid(),true,5));
		network.addLayer(new BasicLayer(new ActivationSigmoid(),false,1));
		network.getStructure().finalizeStructure();
		network.reset();
		
		System.out.println("Neural Network created.");
		return network;
	}
	
	
	public void load() {
		System.out.println("Loading in Neural Network...");
		Network();
	}
}
