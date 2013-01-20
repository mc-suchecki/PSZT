package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An artificial neuron
 * 
 */
public class Neuron {
	private List<Connection> nextNodes = new LinkedList<Connection>();
	private List<Connection> prevNodes = new LinkedList<Connection>();

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
		if (prevNodes.size() != 0) { //check if the node is in input layer
			currentValue = 0;
			for (Connection con : prevNodes) {
				currentValue += con.getWeight()
						* con.getPrevious().getCurrentValue();
			}
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
