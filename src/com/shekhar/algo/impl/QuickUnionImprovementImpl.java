package com.shekhar.algo.impl;

import java.util.Random;

import com.shekhar.algo.QuickUnionImprovements;

public class QuickUnionImprovementImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickUnionImprovements qu = new QuickUnionImprovements(10);
		
//		for(int x=0; x<7 ; x++){
//			qu.union(randomIntGen(10), randomIntGen(10));
//			qu.display();
//
//		}
//		
////		qu.display();
//		
//		for(int x=0; x<10 ; x++){
//			qu.find(randomIntGen(10), randomIntGen(10));
//		}
		
		qu.union(2, 8);
		qu.union(5, 1);
		qu.union(1, 0);
		qu.union(9, 3);
		qu.union(4, 1);
		
		qu.union(6, 4);
		qu.union(8, 3);
		qu.union(9, 5);
		qu.union(3, 7);
		
		
		qu.display();
		
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
