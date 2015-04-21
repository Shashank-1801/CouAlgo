package algoPart2.w1;

import java.util.Iterator;


public class DFS {

	class Node implements Iterable<Integer>{
		Integer value;
		Node next;

		public Node(Integer value){
			this.value = value;
		}

		public void add(Integer w) {
			Node temp = new Node(w);
			this.next = temp;					
		}

		@Override
		public Iterator<Integer> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}


	private final int V;
	private Node[] adj;

	public DFS(int v){
		this.V = v;
		adj = new Node[v];

		for(int i=0; i<v; v++){
			adj[v] = new Node((Integer) null);
		}
	}

	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		
	}
	
	public int V(){
	return this.V;
	}
	
	public int E(){
		return 0;
	}

}