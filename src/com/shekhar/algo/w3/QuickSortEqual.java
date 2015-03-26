package com.shekhar.algo.w3;

public class QuickSortEqual {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int isless( Comparable a, Comparable b){
		return a.compareTo(b);
	}

	@SuppressWarnings("rawtypes")
	private static void doSort(Comparable[] a,int low, int hi){
		for(int i=0; i<a.length; i++){
			int j=i;
			int x=low;
			int y=hi;

			while(x<y){
				while(isless(a[j], a[y]) < 0 || isless(a[j], a[y])== 0 ){  //
					y--;
				}
				while(isless(a[x], a[j]) < 0 && (x < y)){
					x++;
				}
				
				if(x<y){
					exch(a, x, y);
				}				
			}
			exch(a, y, j);

			display(a);
		}
	}

	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	@SuppressWarnings("rawtypes")
	public static void quickSort(Comparable[] a){
		doSort(a, 0, a.length-1);
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
			if(isless(a[i], a[i+1]) > 0){
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
		quickSort(in);
		//		display(in);
		System.out.println(isSorted(in));
		System.out.println("************************");
	}

}
