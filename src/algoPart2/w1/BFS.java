package algoPart2.w1;

import java.util.Iterator;


public class BFS {

	class Node<T> implements Iterable<Integer>{
		T value;
		Node<T> next;

		public Node(T value){
			this.value = value;
		}

		public void add(T w) {
			Node<T> temp = new Node<T>(w);
			this.next = temp;					
		}

		@Override
		public Iterator<Integer> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}


	private final int V;
	private Node<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public BFS(int v){
		this.V = v;
		adj = (Node<Integer>[]) new Node[v];

		for(int i=0; i<v; v++){
			adj[v] = new Node<Integer>((Integer) null);
		}
	}

	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		
	}
	
//	public Iterable<Integer> adj(int v){
//		return adj[v];
//	}

}
