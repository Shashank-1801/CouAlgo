package com.shekhar.algo;

public class UF implements UnionFind{
	
	Node[] node;

	public UF(int n){
		node = new Node[n];	
		for(int i=0; i<n ; i++) {
			node[i] = new Node();
			node[i].setPosition(i);
		}
	}

	public void union(int p, int q) {
		System.out.print("Connection between "+ p + " and " + q);
		if(p!=q){
			node[p].setNode(node[q]);
			node[q].setNode(node[p]);
		}
		System.out.println(" done!");
	}

	//indirect connection not checked yet
	public boolean connected(int p, int q) {
		System.out.print("Nodes " + p + " and " + q + " are ");
		if(p==q) {
			System.out.println("connected!");
			return true;
		}
		Node[] all_nodes = node[p].getNodes();
		if(all_nodes != null) {
			for (Node temp : all_nodes) {
				if(temp == node[q]){
					System.out.println("connected!");
					return true;
				}
			}
		}
		System.out.println("not connected!");
		return false;
	}
	
	public void display() {
		for (int i=0 ; i<node.length; i++) {
			Node[] temp = node[i].getNodes();
			if(temp==null) {
				System.out.println(i + " -> null");		
			}else{
				System.out.print(i);
				for(Node n : temp){
					System.out.print( " -> "+ n.getPosition());
				}
				System.out.println();
			}
		}
	}

}
