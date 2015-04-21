package algoPart2.w1;

import java.util.Random;

public class TestClass {

	public static void main(String[] args) {
		Graph g = new Graph(10);

		g.add(0, 1);
		g.add(1, 2);

		g.add(3, 4);
		g.add(4, 5);

		g.add(6, 7);
		g.add(7, 8);

		for(int i=0; i<10; i++){
			int p = RandomInt(10);
			System.out.println("IsAdj? " + p + " & " + (p+1) + " : " + g.isAdjacent(p, p+1) );
		}

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
