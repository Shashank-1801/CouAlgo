package algoPart2.w1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestClass {

	public static void main(String[] args) {
		Graph g = new Graph(10);

		g.add(0, 1);
		g.add(1, 2);

		g.add(3, 4);
		g.add(4, 5);
		
		g.add(4, 7);

		g.add(6, 7);
		g.add(7, 8);
		
		g.add(3, 0);
		g.add(1, 9);

		for(int i=0; i<10; i++){
			int p = RandomInt(10);
			System.out.println("IsAdj? " + p + " & " + (p+1) + " : " + g.isAdjacent(p, p+1) );
		}
		
		System.out.println("IsAdj? " + 4 + " & " + 7 + " : " + g.isAdjacent(4, 7) );
		
		System.out.println("Adjacent to 4:");
		int[] adj = g.adjList(4);
		for(int x : adj){
			System.out.println(x);
		}

		System.out.println("Adjacent to 1:");
		adj = g.adjList(1);
		for(int x : adj){
			System.out.println(x);
		}
		
//		Queue<Integer> p = new LinkedList<>();
//		p.add(123);
//		System.out.println(p.remove());
		
		BFS b = new BFS(g, 4);
		
		System.out.println(b.isConnected(0, 6));
		System.out.println(b.isConnected(4, 8));
		
		b.displayConnected();
		

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
