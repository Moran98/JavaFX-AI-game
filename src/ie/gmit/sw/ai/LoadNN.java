package ie.gmit.sw.ai;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.encog.util.obj.SerializeObject;

import ie.gmit.sw.ai.nn.*;

public class LoadNN {
	
    private static NeuralNetwork n1;
    private static String FILE = "NN";
    
    public void Load() throws ClassNotFoundException, IOException, Exception {
    	
    	// Checking to see if the file exists
    	boolean exists = true;
    	exists = new File(FILE).exists();
    	System.out.println("Loaded in the Neural Network: " + exists);
    	
    	
        n1 = (NeuralNetwork) SerializeObject.load(new File(FILE));
        
    }
	
    public int run(double[] data) throws Exception{
        double[] result = n1.process(data);
        int output;
        output = Utils.getMaxIndex(result) + 1;
        return output;
    }

}
