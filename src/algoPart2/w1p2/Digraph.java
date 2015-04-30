package algoPart2.w1p2;


public class Digraph{


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

	public Digraph(int V){
		this.V = V;
		vertexList = new Node[V];
	}

	public void add(int x, int y){
		System.out.println("Trying to add " + x +" to " + y + " in digraph!") ;
		Node tempy = new Node(y);
		if( vertexList[x]==null){
			tempy.next = null; 
		}else{
			Node temp = vertexList[x];
			tempy.next = temp;
		}
		vertexList[x] = tempy;
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
