package com.shekhar.algo.impl;

import java.util.Random;

import com.shekhar.algo.UF;

public class UFImpl {


	public static void main(String[] args) {

		UF uf = new UF(10);
			
		for(int x=0; x<7 ; x++){
			uf.union(randomIntGen(10), randomIntGen(10));
		}
		
		uf.display();
		
		for(int x=0; x<10 ; x++){
			uf.find(randomIntGen(10), randomIntGen(10));
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
