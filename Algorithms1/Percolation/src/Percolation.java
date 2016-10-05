import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private WeightedQuickUnionUF uf;
	private boolean[] openFlag;
	
	private final int MAX;
	
	public Percolation(int n) {
		
		MAX = n;
		int node = (MAX*MAX) +2;
		uf = new WeightedQuickUnionUF(node);
		openFlag = new boolean[node];
		
		if(n <= 0 ) {
			throw new IllegalArgumentException("n :" + n + " must up to 0");
		}
		
	}
	
	
	public void open(int i, int j) {
		
		int node = (i-1)*MAX + j;
		
		validate(i, j);
		openFlag[node] = true;
		
		if(checkAroundFull(i, j)) {
			checkAroundOpen(i, j);
		}
		
	}
	
	public boolean isOpen(int i, int j) {
		
		validate(i, j);
		int node = (i-1)*MAX + j;

		return openFlag[node];
	}
	
	public boolean isFull(int i, int j) {
		
		validate(i, j);
		int node = (i-1)*MAX + j;
		
		return uf.connected(0, node); 
	}
	
	public boolean percolates() {
		
		return uf.connected(0, (MAX*MAX) +1);
	}
	
	private void validate(int i, int j) {
		
        if (i < 1 || i > MAX) {
            throw new IndexOutOfBoundsException("row index " + i + " is not between 1 and " + MAX);  
        }
        if (j < 1 || j > MAX) {
            throw new IndexOutOfBoundsException("column index " + j + " is not between 1 and " + MAX);  
        }
    }

	
//	is there full 
	private boolean checkAroundFull(int i, int j) {
		
		if(i == 1)
			return true;
		
//		up
		if(i != 1)
		{
			if(  isFull(i-1, j)) {
				return true;
			}
		}
		
//		down
		if( i != MAX){
			if( isFull(i+1, j)) {
				return true;
			}
		}
		
//		left
		if(j != 1){
			if( isFull(i, j-1)) {
				return true;
			}
		}
		
//		right
		if(j != MAX){
			if(isFull(i, j+1)) {
				return true;
			}
		}
		
		return false;
	}
	
	private void checkAroundOpen(int i, int j) {
		int node = (i-1)*MAX + j ;
		uf.union(0, node);
		
		if(i == MAX){
			uf.union(0, (MAX*MAX) +1);
		}
		
//		up
		if(i != 1)
		{
			if( isOpen(i-1, j) && !isFull(i-1, j)) {
				checkAroundOpen(i-1, j);
			}
		}
		
//		down
		if( i != MAX){
			if( isOpen(i+1, j) && !isFull(i+1, j)) {
				checkAroundOpen(i+1, j);
			}
		}
		
//		left
		if(j != 1){
			if( isOpen(i, j-1) && !isFull(i, j-1)) {
				checkAroundOpen(i, j-1);
			}
		}
		
//		right
		if(j != MAX){
			if(isOpen(i, j+1) && !isFull(i, j+1)) {
				checkAroundOpen(i, j+1);
			}
		}
	}
}
