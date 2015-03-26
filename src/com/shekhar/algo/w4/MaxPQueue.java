package com.shekhar.algo.w4;

public class MaxPQueue<Key extends Comparable<Key>>{

	private Key[] pq ;
	private  int N;

	@SuppressWarnings("unchecked")
	public MaxPQueue(int capacity) {
		pq = (Key[]) new Comparable[capacity+1];
		N = 0;
	}
	
	public void display(){
		for(int i=1; i<N; i++){
			System.out.print(pq[i] + " ");
		}
		System.out.println();
		System.out.println("************");
	}

	public  boolean isEmpty(){
		return N==0;
	}

	public boolean isless( Key a, Key b){
		return a.compareTo(b) < 0;
	}

	public void exch(int i, int j){
		Key temp;
		temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;		
	}

	public void insert(Key key){
		pq[++N] = key;
		swim(N);
	}
	
	public Key maxDel(){
		exch(1, N);
		Key k = pq[N--];
		sink(1);
		pq[N+1] = null;
		return k;
	}
	
	public void sink(int k){
		while(k <= N){
			int c1 = 2*k;
			int c2 = c1+1;
			if(isless(pq[c1],pq[c2]) && isless(pq[k],pq[c2])){
				exch(k,c2);
				k = c2;
			}else if(isless(pq[c2],pq[c1]) && isless(pq[k], pq[c1])){
				exch(k,c1);
				k = c1;
			}else{
				break;
			}
		}
	}
	
	public void swim(int k){
		while(k/2 >= 1){
			if(!isless(pq[k], pq[(int)k/2])){
				exch(k, (int)k/2);
				k = (int) k/2;
			}else{
				break;
			}
		}
	}

}
