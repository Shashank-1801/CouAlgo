package com.shekhar.algo.w2;

import java.util.Random;

public class SelectionSort {

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

	public boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] a){
		for(int i=0; i<a.length-1; i++){
			if(less(a[i], a[i+1])){
				return false;
			}
		}
		return true;
	}
	
	public static void doSort(@SuppressWarnings("rawtypes") Comparable[] a){
		int len = a.length;
		for(int i=0; i<len; i++){
			int min = i;
			for(int j=i; j<len; j++){
				if(less(a[j], a[min])){
					min = j;
				}
			}
			exch(a, i, min);
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
			System.out.println(a[i]);
		}
		System.out.println("************************");
	}

	public static void fill(Comparable[] a){
		Random r = new Random();
		for(int i=0; i<a.length; i++){
			a[i] = (Comparable) r.nextDouble();
		}
	}
	
	public static void main(String[] args){
		String[] aa = {"yy","aa","ab","ba","bb","zz"};
		//fill(aa);
		display(aa);
		doSort(aa);
		display(aa);		
		doSortRev(aa);
		display(aa);		
		
		Integer[] in = {9,1,4,6,8,2,3,7,2,4};
		//fill(in);
		display(in);
		doSort(in);
		display(in);
		
		
	}
}
