package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An artificial neuron
 * 
 */
public class Neuron {
	/** stores connections to nodes in the next layer */
	private List<Connection> nextNodes = new LinkedList<Connection>();
	/** stores connections to nodes in the previous layer */
	private List<Connection> prevNodes = new LinkedList<Connection>();
	/** stores the current value of the neuron */
	private double currentValue;

	public Neuron() {

	}

	public void addNextConnection(Connection con) {
		nextNodes.add(con);
	}

	public void addPrevConnection(Connection con) {
		prevNodes.add(con);
	}

	public double propagateForward() {
		// check if the node is in the input layer
		if (prevNodes.size() != 0)
			currentValue = 0;
		
		for (Connection con : prevNodes) {
			currentValue += con.getWeight()
					* con.getPrevious().getCurrentValue();
		}
		
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
	 * 
	 * @param predefinedValue
	 *            predefined value to set
	 */
	public void setCurrentValue(double predefinedValue) {
		this.currentValue = predefinedValue;
	}

}
