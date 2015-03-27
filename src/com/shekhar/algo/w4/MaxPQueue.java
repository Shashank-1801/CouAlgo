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
		System.out.println("************");
		for(int i=1; i<N+1; i++){
			System.out.print(pq[i] + " ");
		}
		System.out.println();
		System.out.println("************");
	}

	public  boolean isEmpty(){
		return N == 0;
	}

	public boolean isFull(){
		return N == pq.length-1;
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
		System.out.println("Trying to insert: " + key);
		if(!isFull()){
			pq[++N] = key;
			swim(N);
		}else{
			System.out.println("Heap Full");
		}
	}

	public Key maxDel(){
		if(!isEmpty()){
			exch(1, N);
			Key k = pq[N--];
			sink(1);
			pq[N+1] = null;
			return k;
		}else{
			return null;
		}
	}

	public void sink(int k){
		while(2*k+1 <= N){
			int c1 = 2*k;
			int c2 = c1+1;
			if(isless(pq[c1],pq[c2]) && isless(pq[k],pq[c2])){	//pq[c2] is larger than pq[c1] and pq[k]
				exch(k,c2);
				k = c2;
			}else if(isless(pq[c2],pq[c1]) && isless(pq[k], pq[c1])){ //pq[c1] is larger than pq[c2] and pq[k]
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
