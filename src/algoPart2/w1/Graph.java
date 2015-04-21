package algoPart2.w1;

import java.util.Iterator;
import java.util.List;

public class Graph {


	class Node implements Iterator<Integer>{
		int vertex;
		Node next;

		Node(int vertex){
			this.vertex = vertex;
		}

		public Node add(int x){
			this.vertex = x;
			return this;
		}

		@Override
		public boolean hasNext() {
			if(this == null){
				return false;
			}else if(this.next !=null){
				return true;
			}
			return false;
		}

		@Override
		public Integer next() {
			if(hasNext()){
				return this.vertex;
			}
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

	private final int V;
	private Node[] vertexList;

	public Graph(int V){
		this.V = V;
		vertexList = new Node[V];
	}

	public void add(int x, int y){
		System.out.println("Trying to add " + x +" and " + y + " to graph!") ;
		Node tempy = new Node(y);
		if( vertexList[x]==null){
			tempy.next = null; 
		}else{
			Node temp = vertexList[x];
			tempy.next = temp;
		}
		vertexList[x] = tempy;

		Node tempx = new Node(x);
		if(vertexList[y] == null){
			tempx.next = null;
		}else{
			Node temp = vertexList[y];
			tempy.next = temp;
		}
		vertexList[y] = tempx;
	}

	public int V(){
		return V;
	}

	public boolean isAdjacent(int node1, int node2){
		Node x = vertexList[node1];
		while(x!=null){
			if(node2 == x.vertex){
				return true;
			}
			x = x.next;
		}
		return false; 
	}

	public Node list(int vertex){
		return vertexList[vertex];
	}

	public Iterator<Integer> adjList(int vertex){
		
		final int v = vertex;
		
		Iterator<Integer> i = new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				if(vertexList[v] == null){
					return false;
				}else if(vertexList[v].next !=null){
					return true;
				}
				return false;
			}

			@Override
			public Integer next() {
				if(vertexList[v]!= null){
					Integer val = vertexList[v].vertex;
					vertexList[v] = vertexList[v].next;
					return val;
				}
				return null;
			}
			//data lose as the value 3 is not appearing in the list...
			//TODO

			@Override
			public void remove() {
				// TODO Auto-generated method stub

			}
			
		}; 

		return i;


	}

}
