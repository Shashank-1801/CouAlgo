package algoPart2.w1;

import java.util.LinkedList;
import java.util.Queue;


public class BFS {

	final int size;
	boolean[] visited;
	int[] distance;
	int currentDist = 1;
	Graph g;

	Queue<Integer> s = new LinkedList<>();

	BFS(Graph G, int initVertex){
		size = G.V();
		visited = new boolean[size];
		distance = new int[size];
		g = G;
		s.add(initVertex);
		bfs();
	}

	private void bfs(){
		while(!s.isEmpty()){
			Integer ver = s.remove();
			if(ver == null){
				currentDist++;
			}else if(visited[ver]==true){
				currentDist--;
			}
			else if(visited[ver] == false){
				for(int x : g.adjList(ver)){
					s.add(x);
				}
				s.add(null);
				visited[ver] = true;
				distance[ver] = currentDist;
			}else{
				//do nothing
			}
		}
	}

	public boolean isConnected(int x, int y){
		return (visited[x]== true && visited[y]==true);
	}

	public void displayConnected(){
		for(int i=0; i<size; i++){
			System.out.println( i + " --> " + visited[i] + " --> " + distance[i]);
		}
	}

}
