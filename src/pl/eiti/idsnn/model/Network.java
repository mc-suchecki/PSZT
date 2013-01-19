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
	 * As a parameter gets a numbers of nodes in each layer
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
	
	public Value getValue(){
		return layers.get(2).getNodes().get(0).getValue();
	}
	/**
	 * feeds next portion of data to the first layer of neurons
	 */
	public void feedData(){
		//get data form source
		Value val = new Value();
		for(Node node : layers.get(0).getNodes()){
			node.setValue(val);
		}
	}
	public void backPropagate(){
		
	}
	
	
}
