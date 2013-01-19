package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A layer of a neural network
 * 
 */
public class Layer {
	private List<Neuron> neurons = new LinkedList<Neuron>();

	/**
	 * @param number
	 *            of nodes to create in this layer
	 * @param previous_layer
	 *            previous layer object to link nodes to1
	 */
	public Layer(int nodesNumber) {
		for (int i = 0; i < nodesNumber; i++) {
			neurons.add(new Neuron());
		}
	}

	public void addNextLayer(Layer lay) {
		System.out.println("Adding next layer");
		for(Neuron neuron : neurons){
			for(Neuron nextNeuron : lay.getNeurons())
				neuron.addNextConnection(new Connection(neuron, nextNeuron, Math.random()));
		}
	}

	public void addPrevLayer(Layer lay) {
		System.out.println("Adding previous layer");
		for(Neuron neuron : neurons){
			for(Neuron prevNeuron : lay.getNeurons())
				neuron.addNextConnection(new Connection(prevNeuron, neuron, Math.random()));
		}
	}

	public List<Neuron> getNeurons(){
		return neurons;
	}

	public void propagateForward() {
		for(Neuron neuron : neurons)
			neuron.propagateForward();
  }

}
