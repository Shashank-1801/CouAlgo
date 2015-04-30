package algoPart2.w1p2;

import java.util.Random;


public class TestClassw1p2 {

	public static void main(String[] arg){
		Digraph d = new Digraph(10);

		d.add(0, 1);
		d.add(1, 2);
		d.add(3, 0);
		d.add(0, 3);
		d.add(6, 7);
		d.add(4, 7);

		for(int i=0; i<10; i++){
			System.out.print("Adjacent to " + i + " : ");
			int[] adj = d.adjList(i);
			for(int x : adj){
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");

		CC c = new CC(d);
		for(int i=0; i<10; i++){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public static int RandomInt(int limit){
		Random r = new Random();
		int p =-1;
		while(p<0){
			p = r.nextInt()%limit;
		}
		return p;		
	}
}
