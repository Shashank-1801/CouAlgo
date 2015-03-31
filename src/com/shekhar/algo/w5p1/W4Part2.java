package com.shekhar.algo.w5p1;

import java.util.Random;

public class W4Part2 {

	public static void main(String[] args) {
//		SymbolTable<Integer, String> st = new SymbolTable<Integer, String>();
		RedBlackTree<Integer, String> st = new RedBlackTree<Integer, String>();

		
		System.out.println(st.isEmpty());
//		st.put(50, "A");
		st.put(12, null);
		for(int i=0; i<16; i++){
			st.put(RandomInt(),RandomChar());
		}
		st.display();	

		for(int i=0; i<15; i++){
			int r = RandomInt();
			System.out.println("Is "+ r + " present: " +st.contains(r));
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
			v = r.nextInt()%9;
		}
		return v;
	}
}
