package com.shekhar.algo;

public class Node {
	
	int data;
	Node[] connection;
	
	public Node[] getNode(){
		return this.connection;
	}
	
	public void setNode(Node y){
		if(connection.length==0){
			connection = new Node[1];
			connection[0] = y;
		}
		else{
			int old_len = connection.length;
			int new_len = old_len + 1;
			Node[] old_conn = connection;
			connection = new Node[new_len];
			for(int i=0; i < old_len; i++){
				connection[i] = old_conn[i];
			}
		}
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
