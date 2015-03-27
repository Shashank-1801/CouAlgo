package com.shekhar.algo.w4;

import java.util.Random;

public class W4 {

	public static void main(String[] args) {
		MaxPQueue<Integer> p = new MaxPQueue<Integer>(15);

//		for(int i=0; i<13; i++){
//			p.insert(RandomChar());
//		}
//		97 90 95 66 48 88 81 32 57 39   55 15 80

		
		p.insert(97);
		p.insert(90);
		p.insert(95);
		p.insert(66);
		p.insert(48);
		p.insert(88);
		p.insert(81);
		p.insert(32);
		p.insert(57);
		p.insert(39);
		
		p.insert(55);
		p.insert(15);
		p.insert(80);
		
		p.display();

//		88 77 80 64 34 50 60 13 19 30 


		p = null;
		p = new MaxPQueue<Integer>(15);

		p.insert(88);
		p.insert(77);
		p.insert(80);
		p.insert(64);
		p.insert(34);
		p.insert(50);
		p.insert(60);
		p.insert(13);
		p.insert(19);
		p.insert(30);

		p.display();
		
		System.out.println(p.maxDel());
		System.out.println(p.maxDel());
		System.out.println(p.maxDel());

		p.display();
		
		
//		for(int i=0; i<13; i++){
//			System.out.print(p.maxDel() + ", ");
//			}
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
