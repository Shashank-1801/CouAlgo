package com.shekhar.algo.impl;

import java.util.Random;

import com.shekhar.algo.QuickFind;

public class QuickFindImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		
//		for(int x=0; x<7 ; x++){
//			qf.union(randomIntGen(10), randomIntGen(10));
//		}
//		
//		qf.display();
//		
//		for(int x=0; x<10 ; x++){
//			System.out.println("Conneted : " +qf.find(randomIntGen(10), randomIntGen(10)));
//		}
	
		qf.union(3, 5);
		qf.display();
		qf.union(5, 6);
		qf.display();
		qf.union(3, 1);
		qf.display();
		qf.union(8, 0);
		qf.display();
		qf.union(8, 2);
		qf.display();
		qf.union(9, 3);

		qf.display();
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
