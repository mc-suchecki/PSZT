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
		layers.add(new Layer(first, null));
		layers.add(new Layer(second, layers.get(0)));
		layers.add(new Layer(third, layers.get(1)));
	}
	
}
