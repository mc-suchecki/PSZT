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
		for(Connection con : prevNodes)
			con.getPrevious().getValue();
		//TODO sth here with values
		return new Value();
	}
	public void updateWeights(){
		
	}
	/**
	 * sets a predefined value, not computed by the function
	 * for use only in the first layer
	 */
	public void setValue(Value val){
		//TODO implement
	}

}
