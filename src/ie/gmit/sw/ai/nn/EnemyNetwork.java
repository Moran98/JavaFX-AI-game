package ie.gmit.sw.ai.nn;

import java.io.File;
import org.encog.util.obj.SerializeObject;
import ie.gmit.sw.ai.nn.activator.Activator;

public class EnemyNetwork {
	
	private final double[][] data = { //Health, Sword, Enemies
			{2,0,0},{2,0,1},{2,1,0},{2,1,1},{0,0,0},
	        {1,0,0},{1,0,1},{1,1,0},{1,1,1}
	};

	   
	private final double[][] expected = { //Attack,Run
	        {1.0,0.0},{1.0,0.0},{0.0,1.0},{0,0,1.0},{1.0,0.0},
	        {1.0,0.0},{1.0,0.0},{1.0,0.0},{0.0,1.0}
	};
        
        
    public static void main(String[] args) throws Exception {new EnemyNetwork().run();}
    
    public void run() throws Exception {
        
        NeuralNetwork nn = new NeuralNetwork(Activator.ActivationFunction.Sigmoid, 3, 2, 2);
        BackpropagationTrainer trainer = new BackpropagationTrainer(nn);
        trainer.train(data, expected, 0.01, 100000);
        
        SerializeObject.save(new File("NN"), nn);
            
        double[] test = {2, 0, 0};
        double[] result = nn.process(test);
    }
}
