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
}
