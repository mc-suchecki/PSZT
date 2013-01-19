package pl.eiti.idsnn.model;

import java.util.LinkedList;
import java.util.List;

/**
 * An artificial neuron 
 * 
 */
public class Node {
	private List<Connection> nextNodes = new LinkedList<Connection>();
	private List<Connection> prevNodes = new LinkedList<Connection>();
	
	public Node(){
		
	}
	public void addNextConnection(Connection con){
		nextNodes.add(con);
	}
	public void pervNextConnection(Connection con){
		prevNodes.add(con);
	}
	public Value getValue(){
		return new Value();
	}
	public void updateWeights(){
		
	}

}
