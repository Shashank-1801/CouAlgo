package algoPart2.w1;

public class Graph{


	class Node {
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
			tempx.next = temp;
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

	public int[] adjList(int vertex){
		int count =0;
		Node temp = vertexList[vertex];
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		
		int[] list = new int[count];
		temp = vertexList[vertex];
		for(int i=0; i<count; i++,temp=temp.next){
			list[i] = temp.vertex;
		}
		return list;
	}

}
