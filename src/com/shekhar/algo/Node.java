package com.shekhar.algo;

public class Node {
	
	int position;
	Node[] connection;
	
	public Node() {
		position = -1;
		connection = null;
	}
	
	public Node[] getNodes(){
		return this.connection;
	}
	
	public void setNode(Node y){
		if(connection == null){
			connection = new Node[1];
			connection[0] = new Node();
			connection[0] = y;
		}
		else{
			Node[] old_conn = connection;
			for (Node n : old_conn) {
				if(n == y){
					return;
				}
			}
			int old_len = connection.length;
			int new_len = old_len + 1;
		
			connection = new Node[new_len];
			for(int i=0; i < old_len; i++){
				connection[i] = new Node();
				connection[i] = old_conn[i];
			}
			connection[new_len-1] = y;
		}
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Node" + position;
	}

}
