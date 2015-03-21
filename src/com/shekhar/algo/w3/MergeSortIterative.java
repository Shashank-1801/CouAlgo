package com.shekhar.algo.w3;

public class MergeSortIterative {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean isless( Comparable a, Comparable b){
		return (a.compareTo(b) < 0);
	}
	
	@SuppressWarnings("rawtypes")
	private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){
		int i = low;		//i from low to mid
		int j = mid+1;		//j from mid+1 to high-1
		
//		if(i==j){
//			return;
//		}
		
		for(int p=low; p<high; p++){
			aux[p] = a[p];
		}
		
		int k = low;		
		while(k < high){
			if(i > mid) {
				a[k] = aux[j++];
			}else if(j > high-1){
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
	public static void mergeSort(Comparable[] a){
		int size = a.length;
		Comparable[] aux = new Comparable[size];
		for(int i=1; i<size; i= i*2){
			for(int j=0; j<size-1; j= j+2*i){
				merge(a, aux, j, j+i-1, Math.min(j+2*i, size));
			}
		}
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
		Integer[] in = {38,36,10,18,96,65,56,82,80,12,86,61};
		//fill(in);
		display(in);
		mergeSort(in);
//		display(in);
		System.out.println(isSorted(in));
		System.out.println("************************");
	}

}
