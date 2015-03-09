package com.shekhar.algo;

public class QuickUnionImprovements implements UnionFindInterface{
	
	int[] id;
	int[] size;
	
	public QuickUnionImprovements(int n){
		id = new int[n];
		size = new int[n];
		for (int i=0; i<n ; i++){
			id[i] = i;
			size[i] = 1;
		}
	}

	public void union(int p, int q) {
		System.out.print("Connection between "+ p + " and "+ q);
		int rootp = root(id[p]);
		int rootq = root(id[q]);
		if(rootp == rootq){
			System.out.println(" already exists!");		
			return;
		}
		if(size[rootp] < size[rootq]){
			id[rootp] = rootq;
			size[rootq] += size[rootp];
		}else{
			id[rootq] = rootp;
			size[rootp] += size[rootq];
		}
		System.out.println(" done!");		
	}

	public boolean find(int p, int q) {
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
//			id[parent] = id[id[parent]];	//Path compression
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
			System.out.print( i + " ");
		}
		System.out.println();
		for(int i=0; i<id.length; i++){
			System.out.print(  id[i] + " ");
		}
		System.out.println();
		for(int i=0; i<id.length; i++){
			System.out.print( size[i] + " ");
		}
		System.out.println();
	}
}
