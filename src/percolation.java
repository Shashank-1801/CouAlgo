
public class percolation{
	
	boolean[] sites;
	int[][] connection;
	
	int vtop;
	int vbottom;
	
	
	public percolation(int n){
		int nsqr = n*n;
		sites = new boolean[nsqr];
		connection = new int[nsqr][1];
		for(int i=0; i<nsqr ; i++){
			sites[i] = false;
		}	
	}
	
	public void union(int p, int q){
		
	}
	

}
