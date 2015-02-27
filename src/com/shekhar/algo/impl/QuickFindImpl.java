package com.shekhar.algo.impl;

import java.util.Random;

import com.shekhar.algo.QuickFind;

public class QuickFindImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		
		for(int x=0; x<7 ; x++){
			qf.union(randomIntGen(10), randomIntGen(10));
		}
		
		qf.display();
		
		for(int x=0; x<10 ; x++){
			System.out.println("Conneted : " +qf.connected(randomIntGen(10), randomIntGen(10)));
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
