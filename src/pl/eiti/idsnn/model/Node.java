package pl.eiti.idsnn.model;

import java.util.List;

/**
 * An artificial neuron 
 * 
 */
public class Node {
	private List<Connection> nextNodes;
	private List<Connection> prevNodes;
	
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
