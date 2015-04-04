package com.shekhar.algo.w5p2;

import java.util.Random;

public class W5Part2 {

	public static void main(String[] args) {
//		SymbolTable<Integer, String> st = new SymbolTable<Integer, String>();
		OIBST<Integer, String> st = new OIBST<Integer, String>();

		
		System.out.println(st.isEmpty());
		st.put(6, 12, null);
		for(int i=0; i<16; i++){
			st.put(RandomInt(), RandomInt(), RandomChar());
		}

//		Integer[] in = {78,32,81,23,62,79,99,11,24,92};
//		
//		for (Integer integer : in) {
//			st.put(integer, RandomChar());
//		}
//		
		st.display();
//		st.displayInOrder();
//		
//		Integer[] in2 = {39, 29 , 96};
//		for (Integer integer : in2) {
//			st.put(integer, RandomChar());
//		}
//		st.display();	
//
//		for(int i=0; i<15; i++){
//			int r = RandomInt();
//			System.out.println("Is "+ r + " present: " +st.contains(r));
//		}
//		
		st.displayInOrder();
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
	
	public static int RandomInt(){
		Random r = new Random();
		int v = -1;
		while(v<0){
			v = r.nextInt()%9;
		}
		return v;
	}
}
