package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An artificial neuron class.
 */
public class Neuron {
	/** Stores connections to nodes in the next layer */
	private List<Connection> nextNodes = new LinkedList<Connection>();

	/** Stores connections to nodes in the previous layer */
	private List<Connection> prevNodes = new LinkedList<Connection>();
	
	/** Stores the current value of the neuron */
	private double currentValue;
	private double delta;

	public Neuron() {

	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}
	
	public void updateDelta() {
	  double newDelta = 0;
	  for(Connection conn : nextNodes) {
	    newDelta += conn.getWeight() * conn.getNext().getDelta();
	  }
	  
	  //delta times derivative of activation function
	  this.delta = newDelta * currentValue * (1 - currentValue);
	}

	public void updateWeights(double nuFactor) {
	  for(Connection conn : prevNodes) {
	    double dW, prevWeight;
	    
	    //change of weight
	    dW = nuFactor * conn.getPrevious().getCurrentValue() * delta;
	    prevWeight = conn.getWeight();
	    	    
	    conn.setWeight(prevWeight + dW);
	  }
	}
	
	public void addNextConnection(Connection con) {
		nextNodes.add(con);
	}

	public void addPrevConnection(Connection con) {
		prevNodes.add(con);
	}

	public double propagateForward() {
		//if this is an input layer, there is nothing to do
		if(prevNodes.size() == 0) return currentValue;
		
		//sum weights * values from all previous neurons
	  currentValue = 0;
		for(Connection con : prevNodes) {
			currentValue += con.getWeight()
					* con.getPrevious().getCurrentValue();
		}
		
		//use activation function over computed value
		currentValue = 1.0 / (1.0 + Math.exp(-currentValue));
		
		return currentValue;
	}

	/**
	 * @return current neuron return value
	 */
	public double getCurrentValue() {
		return currentValue;
	}

	/**
	 * Sets a predefined value, not computed by the function. For use only in
	 * the first layer.
	 * @param predefinedValue predefined value to set
	 */
	public void setCurrentValue(double predefinedValue) {
		this.currentValue = predefinedValue;
	}

}
