package pl.eiti.idsnn.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A neural network class.
 */
public class Network {
	List<Layer> layers = new ArrayList<Layer>();
	
	public Network() {
		
	}
	
	/**
	 * Method responsible for adding new Layer to Network.
	 */
	public void addLayer(Layer newLayer) {
		layers.add(newLayer);
		if(layers.size() == 1) return;
		Layer previousLayer = layers.get(layers.size() - 2);
		previousLayer.addNextLayer(newLayer);
		newLayer.addPrevLayer(previousLayer);
	}
	
	/**
	 * Method responsible for calculating the results from initial values.
	 * @return results of the forward propagation - vector of values from last Layer.
	 * @throws Exception 
	 */
	public List<Double> forwardPropagate(final double[] inputValues) throws Exception {
		
		if(inputValues.length != layers.get(0).getNeurons().size())
			throw new Exception();
		
		//feed data to first layer
		int i = 0;
		for(Neuron neuron : layers.get(0).getNeurons()){
			neuron.setCurrentValue(inputValues[i]);
			i++;
		}
		
		for(Layer layer : layers)
			layer.propagateForward();
		
		//return results
		List<Double> results = new ArrayList<Double>();
		for(Neuron neuron : layers.get(layers.size()-1).getNeurons())
			results.add(neuron.getCurrentValue());
		return results;
	}
	
	/**
	 * Method responsible for ...
	 */
	public void backPropagate(Double result){
		
	}
	
}
