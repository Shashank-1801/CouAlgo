package com.shekhar.algo;

public class QuickUnion implements UnionFind{
	
	int[] id;
	
	public QuickUnion(int n){
		id = new int[10];
		for (int i=0; i<n ; i++){
			id[i] = i;
		}
	}

	@Override
	public void union(int p, int q) {
		System.out.print("Connection between "+ p + " and "+ q);
			id[root(p)] = root(q);
		System.out.println(" done!");		
	}

	@Override
	public boolean connected(int p, int q) {
		System.out.print(p + " and " + q + " are ");
		if(root(p) == root(q)){
			System.out.println("connected!");
			return true;
		}
		System.out.println("not connected!");
		return false;
	}
	
	
	public int parent(int x){
		return id[x];
	}
	
	public int root(int x) {
		int parent = id[x];
		while(parent != id[parent]){
			parent = id[parent];
		}
		return parent;
	}
	
	public int recRoot(int x){
		if(parent(x) == x)
			return x;
		else{
			return recRoot(parent(x));
		}
	}
	
	public void display(){
		for(int i=0; i<id.length; i++){
			System.out.println( i + " -> "+ id[i] + " root at " + root(i));
		}
	}
}
