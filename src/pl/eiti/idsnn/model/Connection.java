package pl.eiti.idsnn.model;

public class Connection {
	private Neuron previous;
	private Neuron next;
	private double weight;
	
	public Connection(Neuron previous, Neuron next, double weight) {
		this.previous = previous;
		this.next = next;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Neuron getPrevious() {
		return previous;
	}

	public Neuron getNext() {
		return next;
	}
}
