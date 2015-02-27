package com.shekhar.algo;

public class UF implements UnionFind{
	
	Node[] node;

	UF(int n){
		node = new Node[n];	
	}

	public void union(int p, int q) {
		node[p].setNode(node[q]);
		node[q].setNode(node[q]);
	}

	public boolean connected(int p, int q) {
		Node[] all_nodes = node[p].getNode();
		for (Node temp : all_nodes) {
			if(temp == node[q])
				return true;
		}

		return false;
	}

}
