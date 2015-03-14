package com.shekhar.algo.w2;

import java.io.StreamCorruptedException;
import java.util.Random;

public class Suffling {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;	
	}
	
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] a){
		for(int i=0; i<a.length-1; i++){
			if(less(a[i], a[i+1])){
				return false;
			}
		}
		return true;
	}
	
	public static void doShuffle(@SuppressWarnings("rawtypes") Comparable[] a){
		int len = a.length;
		Random r = new Random();
		int randomPos = 0;
		for(int i=0; i<len; i++){
			while(randomPos < 0){
				randomPos = r.nextInt()%i;
			}
			exch(a, i, randomPos);
		}
	}
	
	public static void doSortRev(@SuppressWarnings("rawtypes") Comparable[] a){
		int len = a.length;
		for(int i=0; i<len; i++){
			int min = i;
			for(int j=i; j<len; j++){
				if(less(a[min], a[j])){
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
	
	public static void display(Comparable[] a){
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void fill(Comparable[] a){
		Random r = new Random();
		for(int i=0; i<a.length; i++){
			a[i] = (Comparable) r.nextDouble();
		}
	}
	
	public static void main(String[] args){
//		String[] aa = {"yy","aa","ab","ba","bb","zz"};
//		//fill(aa);
//		display(aa);
//		doShuffle(aa);
//		display(aa);		
//		doSortRev(aa);
//		display(aa);	
//		System.out.println(isSorted(aa));
//		System.out.println("************************");
//		
//		Integer[] in = {9,1,4,6,8,2,3,7,2,4};
//		//fill(in);
//		while(!isSorted(in)){
//			doShuffle(in);
//			display(in);
//		}
//		display(in);
//		System.out.println(isSorted(in));
//		System.out.println("************************");
//		
		
		String alp = "abcd0123456789efghi0123456789jklmnopqrstuvwxyz0123456789".toUpperCase();
		String a="";
		for(int i=65; i<=90; i++){
			a = a.concat(Character.toString((char)(i)));
		}
		a = a.concat(a);
		a = a.concat(a);
		a = a.concat(a);
		a = a.concat(a);
		a = a.concat(a);

		System.out.println(a);
		String[] alphabet = a.split("");
		while(!isSorted(alphabet)){
			doShuffle(alphabet);
			display(alphabet);
		}
		display(alphabet);
		System.out.println(isSorted(alphabet));
		System.out.println("************************");
	}
}
