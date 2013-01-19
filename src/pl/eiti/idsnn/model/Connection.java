package pl.eiti.idsnn.model;

public class Connection {
	private Node previous;
	private Node next;
	private double weight;
	
	public Connection(Node previous, Node next, double weight) {
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

	public Node getPrevious() {
		return previous;
	}

	public Node getNext() {
		return next;
	}
}
