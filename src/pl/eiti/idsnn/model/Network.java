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
		// gets the value of the first (and only) neuron in the last layer
		// which is recursively computed from the previous values
		return layers.get(2).getNodes().get(0).getValue();
	}
	/**
	 * feeds next portion of data to the first layer of neurons
	 */
	public void feedData(List<Double> data){
		//get data form source
		Value val = new Value();
		int i = 0;
		for(Node node : layers.get(0).getNodes()){
			node.setValue(data.get(i));
			i++;
		}
	}
	public void backPropagate(Boolean result){
		
	}
	
	
}
