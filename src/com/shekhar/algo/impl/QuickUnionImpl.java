package com.shekhar.algo.impl;

import java.util.Random;

import com.shekhar.algo.QuickUnion;

public class QuickUnionImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion(10);
		
		for(int x=0; x<7 ; x++){
			qu.union(randomIntGen(10), randomIntGen(10));
		}
		
		qu.display();
		
		for(int x=0; x<10 ; x++){
			qu.connected(randomIntGen(10), randomIntGen(10));
		}
		
//		qu.union(4, 3);
//		qu.union(3, 8);
//		qu.union(6, 5);
//		qu.union(9, 4);
//		qu.union(2, 1);
//		
//		qu.union(5, 0);
//		qu.union(7, 2);
//		qu.union(6, 1);
//		qu.union(7, 3);
//		
//		qu.display();
		
	}
	
	static int randomIntGen(int upperlimit){
		int value;
		Random r = new Random();
		do{
			value = (r.nextInt())%upperlimit;
		}while(value<0);
		return value;
		
	}

}
