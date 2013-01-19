package pl.eiti.idsnn.model;

import java.util.List;

/**
 * A layer of a neural network
 * 
 */
public class Layer {
	
	private List<Node> nodes;
	
/**
 * @param number of nodes to create in this layer 
 * @param previous_layer previous layer object to link nodes to1
 */
	public Layer(int nodesNumber) {
		for (int i = 0; i<nodesNumber; i++) {
			nodes.add(new Node());
		}
	}
public void addNextLayer(Layer lay){
	System.out.println("Adding next layer");
}
public void addPrevLayer(Layer lay){
	System.out.println("Adding previous layer");
}
	public void updateWeights(){
		
	}
	
}
