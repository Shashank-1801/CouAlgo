package com.shekhar.algo.impl;

import java.util.Random;

import com.shekhar.algo.QuickFind;
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
