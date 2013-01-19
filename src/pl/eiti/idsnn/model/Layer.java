package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A layer of a neural network
 * 
 */
public class Layer {

	private List<Node> nodes = new LinkedList<Node>();

	/**
	 * @param number
	 *            of nodes to create in this layer
	 * @param previous_layer
	 *            previous layer object to link nodes to1
	 */
	public Layer(int nodesNumber) {
		for (int i = 0; i < nodesNumber; i++) {
			nodes.add(new Node());
		}
	}

	public void addNextLayer(Layer lay) {
		System.out.println("Adding next layer");
		double weight = 0.5; //TODO random?
		for(Node node : nodes){
			for(Node nextNode : lay.getNodes())
				node.addNextConnection(new Connection(node, nextNode, weight));
		}
	}

	public void addPrevLayer(Layer lay) {
		System.out.println("Adding previous layer");
		double weight = 0.5; //TODO random?
		for(Node node : nodes){
			for(Node prevNode : lay.getNodes())
				node.addNextConnection(new Connection(prevNode, node, weight));
		}
	}

	public void updateWeights() {

	}
	
	public List<Node> getNodes(){
		return nodes;
	}

}
