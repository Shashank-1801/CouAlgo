package com.shekhar.algo.w3;

public class MergeSort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean isless( Comparable a, Comparable b){
		return (a.compareTo(b) < 0);
	}
	
	@SuppressWarnings("rawtypes")
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){
		int i = low;
		int j = mid+1;
		
//		if(i==j){
//			return;
//		}
		
		for(int p=low; p<=high; p++){
			aux[p] = a[p];
		}
		
		int k = low;		
		while(k <= high){
			if(i > mid) {
				a[k] = aux[j++];
			}else if(j > high){
				a[k] = aux[i++];
			}else if(isless(aux[j] ,aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
			}
			k++;
		}
		display(a);
	}
	
	@SuppressWarnings("rawtypes")
	private static void doSort(Comparable[] a,Comparable[] aux, int low, int hi){
		int mid = low +(hi-low)/2;
		if(low==hi){
			return;
		}
		doSort(a,aux, low, mid);
		doSort(a,aux, mid+1, hi);
		merge(a, aux, low, mid, hi);
	}
	
	@SuppressWarnings("rawtypes")
	public static void mergeSort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		doSort(a, aux, 0, a.length-1);
	}
	
	@SuppressWarnings("rawtypes")
	public static void display(Comparable[] a){
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("************************");
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] a){
		for(int i=0; i<a.length-1; i++){
			if(isless(a[i+1], a[i])){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
//		Integer[] in = {38,36,10,18,96,65,56,82,80,12,86,61};
		String[] in = {"sink","lazy","less","trie","size","type","ceil","push","exch","flip","swap","hash"};		
		//fill(in);
		display(in);
		mergeSort(in);
//		display(in);
		System.out.println(isSorted(in));
		System.out.println("************************");
	}

}
