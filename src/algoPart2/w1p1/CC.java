package algoPart2.w1p1;

public class CC {

	Graph g;
	int size;
	int[] id_array;
	boolean[] visited;
	int conVal = -1;
	
	public CC(Graph g){
		this.g = g;
		size = g.V();
		id_array = new int[size];
		visited = new boolean[size];
		
		for(int i=0; i<size; i++){
			if(visited[i] == false) conVal++;
			dfs(i);
			display();
		}
	}
	
	private void dfs(int i){
		if(visited[i] == true){
			return;
		}else{
			visited[i] = true;
			id_array[i] = conVal;
			for(int m : g.adjList(i)){
				dfs(m);
			}
		}
		
	}
	
	public boolean isConnected(int vertex1, int vertex2){
		return false;
	}
	
	public int id(int vertex){
		return 0;
	}
	
	public int count(){
		return 0;
	}
	
	public void display(){
		for(int i=0; i<size; i++){
			if(visited[i] == true) System.out.print("T ");
			else					System.out.print("F ");
		}
		System.out.println();
		for(int i=0; i<size; i++){
			System.out.print(id_array[i] + " ");
		}
		System.out.println();
	}
	

}
