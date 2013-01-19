package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A neural network
 * 
 */
public class Network {
	List<Layer> layers = new LinkedList<Layer>();
	
	/**
	 * Gets numbers of nodes in each layer
	 */
	public Network(int first, int second, int third){
		layers.add(new Layer(first));
		layers.add(new Layer(second));
		layers.add(new Layer(third));
		
		layers.get(0).addNextLayer(layers.get(1));
		
		layers.get(0).addPrevLayer(layers.get(0));
		layers.get(0).addNextLayer(layers.get(2));
		
		layers.get(0).addPrevLayer(layers.get(1));
	}
	
}
