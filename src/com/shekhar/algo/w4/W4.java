package com.shekhar.algo.w4;

import java.util.Random;

public class W4 {

	public static void main(String[] args) {
		MaxPQueue<String> p = new MaxPQueue<String>(10);

		for(int i=0; i<13; i++){
			p.insert(RandomChar());
		}
		p.display();

		for(int i=0; i<13; i++){
			System.out.print(p.maxDel() + ", ");
			}
	}


	public static String RandomChar(){
		Random r = new Random();
		int v = -1;
		while(v<0){
			v = r.nextInt()%26;
		}
		v = v + 65;
		String s = (Character.toString((char)v));
		return s;
	}

}
