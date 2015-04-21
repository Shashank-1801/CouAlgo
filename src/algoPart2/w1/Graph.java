package algoPart2.w1;

public class Graph {

	
	class Node{
		int vertex;
		Node next;
		
		Node(int vertex){
			this.vertex = vertex;
		}
		
		public Node add(int x){
			this.vertex = x;
			return this;
		}
	}
	
	private final int V;
	private Node[] vertexList;
	
	public Graph(int V){
		this.V = V;
		vertexList = new Node[V];
	}
	
	public void add(int x, int y){
		vertexList[x].add(y);
		vertexList[y].add(x);
	}

	public int V(){
		return V;
	}

}
