package com.shekhar.algo.w5p2;

import java.util.Random;

public class W5Part2 {

	public static void main(String[] args) {
//		SymbolTable<Integer, String> st = new SymbolTable<Integer, String>();
		OIBST<Integer, String> st = new OIBST<Integer, String>();

		
//		System.out.println(st.isEmpty());
//		st.put(6, 12, null);
//		for(int i=0; i<15; i++){
//			int p = RandomInt();
//			st.put(p, RandomInt(p), RandomChar());
//		}


//		A (0.91, 0.24)
//		B (0.21, 0.59)
//		C (0.64, 0.63)
//		D (0.98, 0.15)
//		E (0.22, 0.08)
//		F (0.08, 0.30)
//		G (0.77, 0.32)
//		H (0.54, 0.21)		

//		st.put(91, 24, "A");
//		st.put(21, 59, "B");
//		st.put(64, 63, "C");
//		st.put(98, 15, "D");
//		st.put(22, 8, "E");
//		st.put(8, 30, "F");
//		st.put(77, 32, "G");
//		st.put(54, 21, "H");
	
		
//		A [20, 31]
//		B [21, 39]
//		C [ 5, 24]
//		D [12, 22]
//		E [23, 33]
//		F [13, 36]
//		G [ 3, 30]
//		H [32, 37]
		
		st.put(20, 31, "A");
		st.put(21, 39, "B");
		st.put(5, 24, "C");
		st.put(12, 22, "D");
		st.put(23, 33, "E");
		st.put(13, 36, "F");
		st.put(3, 30, "G");
		st.put(32, 37, "H");	
		
		st.display();
		st.displayLevelOrder();
		
		
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
		for(int i=0; i<7; i++){
			int p = RandomInt();
			int q = RandomInt(p);
			System.out.println("Does (" + p + ", "+ q+ ") intersects? " +st.intersects(p, q));
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
		
	public static int RandomInt(){
		Random r = new Random();
		int v = -1;
		while(v<0){
			v = r.nextInt()%20;
		}
		return v;
	}
	
	public static int RandomInt(int x){
		Random r = new Random();
		int v = -1;
		while(v<x){
			v = r.nextInt()%30;
		}
		return v;
	}
}
