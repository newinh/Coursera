import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * @author HOON
 * @date   2016. 11. 2.
 */
public class Board {
	
	private int dimension;
	private int[][] blocks;
	
	private int blankLow;
	private int blankCol;
	
	public Board(int[][] blocks){
		dimension = blocks.length;
		this.blocks = new int[dimension][dimension];
		
		for(int i = 0 ; i < dimension ; i++)
			for(int j = 0 ; j < dimension ; j++){
				
				if(blocks[i][j] == 0){
					blankLow = i;
					blankCol = j;
				}
					
				
				this.blocks[i][j] = blocks[i][j];
			}
	}
	
	public int dimension(){
		return dimension;
	}
	
	public int hamming(){
		
		int ham = 0;
		
		for(int i = 0 ; i < dimension ; i ++ )
			for(int j = 0 ; j < dimension ; j ++){
				
				if(blocks[i][j] != (i*dimension)+ (j+1) && blocks[i][j] != 0 ){
					ham++;
				}
			}
		
		return ham;
		
	}
	
	public int manhattan(){
		
		int man = 0;
		
		for(int i = 0 ; i < dimension ; i ++ )
			for(int j = 0 ; j < dimension ; j ++){
				
				if(blocks[i][j] != (i*dimension)+ (j+1) && blocks[i][j] != 0 ){
					
					int d = blocks[i][j];
					d--;
					
					int original_low = d / dimension;
					int original_col = d % dimension;
					
					man += Math.abs(i - original_low);
					man += Math.abs(j - original_col);
				}
			}
		
		return man;
	}
	
	public boolean isGoal(){
		
		for(int i = 0 ; i < dimension ; i ++ )
			for(int j = 0 ; j < dimension ; j ++){
				
				
				if(blocks[i][j] != (i*dimension)+ (j+1) ){
					
					if(i == dimension-1 && j == dimension-1)
						return true;
					
					return false;
				}
					
			}
				
		
		return true;
	}
	
	public Board twin(){
		
		int[][] newBlocks = new int[dimension][dimension];
		
		for(int i = 0 ; i < dimension ; i++)
			for(int j = 0 ; j < dimension ; j++){
				newBlocks[i][j] = blocks[i][j];
			}
		
		int a = 0, b = 0;
		int i = 0, j = 0, k = 0, l = 0;
		int tmp;
		
		while( a == 0  ){
			i = (int) (Math.random()*dimension);
			j = (int) (Math.random()*dimension);
			a = newBlocks[i][j];
		}
		
		while( b == 0 || a == b ){
			k = (int) (Math.random()*dimension);
			l = (int) (Math.random()*dimension);
			b = newBlocks[k][l];
		}
		
		tmp = a;
		
		newBlocks[i][j] = newBlocks[k][l];
		newBlocks[k][l] = tmp;
		
		Board newBoard = new Board(newBlocks);
		
		return newBoard;
	}
	
	
	public boolean equals(Object y){
		
		
		Board that = (Board) y;
		
		for(int i = 0 ; i < dimension ; i++)
			for(int j = 0 ; j < dimension ; j++){
				if(blocks[i][j] != that.blocks[i][j])
					return false;
			}
			
		
		
		return true;
	}
	
	public Iterable<Board> neighbors(){
		
		Queue<Board> q = new Queue<Board>();
		
		if(blankCol != dimension-1){
			
			int[][] newBlocks = new int[dimension][dimension];
			for(int i = 0 ; i < dimension ; i++)
				for(int j = 0 ; j < dimension ; j++){
					newBlocks[i][j] = blocks[i][j];
				}
			Board newBoard = new Board(newBlocks);
			
			int tmp = newBoard.blocks[blankLow][blankCol+1];
			newBoard.blocks[blankLow][blankCol+1] = 0;
			newBoard.blocks[blankLow][blankCol] = tmp;
			
			newBoard.blankCol++;
			
			q.enqueue(newBoard);
		}
		
		
		if(blankCol != 0){
			
			int[][] newBlocks = new int[dimension][dimension];
			for(int i = 0 ; i < dimension ; i++)
				for(int j = 0 ; j < dimension ; j++){
					newBlocks[i][j] = blocks[i][j];
				}
			Board newBoard = new Board(newBlocks);
			
			int tmp = newBoard.blocks[blankLow][blankCol-1];
			newBoard.blocks[blankLow][blankCol-1] = 0;
			newBoard.blocks[blankLow][blankCol] = tmp;
			
			newBoard.blankCol--;
			q.enqueue(newBoard);
		}
		
		if(blankLow != dimension-1){
			
			int[][] newBlocks = new int[dimension][dimension];
			for(int i = 0 ; i < dimension ; i++)
				for(int j = 0 ; j < dimension ; j++){
					newBlocks[i][j] = blocks[i][j];
				}
			Board newBoard = new Board(newBlocks);
			
			int tmp = newBoard.blocks[blankLow+1][blankCol];
			newBoard.blocks[blankLow+1][blankCol] = 0;
			newBoard.blocks[blankLow][blankCol] = tmp;
			
			newBoard.blankLow++;
			
			q.enqueue(newBoard);
		}
		
		if(blankLow != 0){
			
			int[][] newBlocks = new int[dimension][dimension];
			for(int i = 0 ; i < dimension ; i++)
				for(int j = 0 ; j < dimension ; j++){
					newBlocks[i][j] = blocks[i][j];
				}
			Board newBoard = new Board(newBlocks);
			
			int tmp = newBoard.blocks[blankLow-1][blankCol];
			newBoard.blocks[blankLow-1][blankCol] = 0;
			newBoard.blocks[blankLow][blankCol] = tmp;
			
			newBoard.blankLow--;
			
			q.enqueue(newBoard);
		}
			
		
		
		return q;
	}
	
	public String toString(){
		
		StringBuilder s = new StringBuilder();
		s.append(dimension + "\n");
		for(int i = 0 ; i < dimension ; i++){
			for(int j = 0 ; j < dimension ; j++)
				s.append(String.format("%5d ", blocks[i][j]) );
			s.append("\n");
		}
		return s.toString();
	}
	
	public static void main(String[] args){
		
		In in = new In();
	    int n = in.readInt();
	    int[][] blocks = new int[n][n];
	    for (int i = 0; i < n; i++)
	        for (int j = 0; j < n; j++)
	            blocks[i][j] = in.readInt();
	    Board initial = new Board(blocks);
	    
	    for(Board b : initial.neighbors())
	    	System.out.println(b.toString());
	            
	}

}
