package com.shekhar.algo;

public class QuickFind implements UnionFind {

	int[] node_id;
	
	public QuickFind(int n) {
		node_id = new int[n];
		for(int i=0; i<n;i++){
			node_id[i] = i;
		}
	}
	
	@Override
	public void union(int p, int q) {
		int pid = node_id[p];
		int qid = node_id[q];
		//mark to the lower value for ids
		if(pid < qid){
			for(int i=0; i< node_id.length; i++){
				if(node_id[i] == qid ){
					node_id[i] = pid; 
				}
			}
		}else{
			for(int i=0; i< node_id.length; i++){
				if(node_id[i] == pid ){
					node_id[i] = qid; 
				}
			}
		}
		System.out.println("Union of " + p +" and " + q + " done!");
	}

	@Override
	public boolean connected(int p, int q) {
		if(node_id[p]==node_id[q]){
			System.out.println(p + " and "+ q +" is connected");
			return true;
		}else{
			System.out.println(p + " and "+ q +" is not connected");

			return false;
		}
	}
	
	public void display(){
		for(int i=0; i<node_id.length; i++){
			System.out.println( i + " -> "+ node_id[i] );
		}
	}

}
