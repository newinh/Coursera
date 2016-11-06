import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author HOON
 * @date   2016. 11. 2.
 */
public class Solver {
	
	int moves;
	MinPQ<Board> MPQ;
	MinPQ<Board> MPQ2;
	
	Board now;
	Board pre;
	
	Board twin;
	Board pre2;
	
	Queue<Board> q;
	
	boolean isSolvable = true;
	
	public Solver(Board initial){
		
		if(initial == null)
			throw new java.lang.NullPointerException();
		
		MPQ = new MinPQ<Board>(new ManCom());
		MPQ2 = new MinPQ<Board>(new ManCom());
		
		q = new LinkedList<Board>();
		
		now = initial;
		pre = initial;
		twin = now.twin();
		pre2 = twin;
		moves = 0;
		
		while( !now.isGoal() &&  !twin.isGoal()){
			
			moves++;
			
			for(Board b : now.neighbors() ){
				
				if(!b.equals(pre)){
					b.move = moves;
					MPQ.insert(b);
				}
			}
			
			pre = now;
			now = MPQ.delMin();
			q.offer(now);
			
			for(Board b : twin.neighbors() ){
				
				if( !b.equals(pre2)){
					b.move = moves;
					MPQ2.insert(b);
				}
			}
			pre2 = twin;
			twin = MPQ2.delMin();
			
		}
		
		
		if(twin.isGoal()){
			isSolvable = false;
			moves = -1;
		}
	}
	
	public boolean isSolvable(){
		return isSolvable;
	}
	
	public int moves(){
		return moves;
	}
	
	public Iterable<Board> solution(){
		
		if(!isSolvable)
			return null;
		
		
		return q;
	}
	
	public static void main(String[] args) {

	    // create initial board from file
//		In in = new In();
	    In in = new In(args[0]);
	    int n = in.readInt();
	    int[][] blocks = new int[n][n];
	    for (int i = 0; i < n; i++)
	        for (int j = 0; j < n; j++)
	            blocks[i][j] = in.readInt();
	    Board initial = new Board(blocks);

	    // solve the puzzle
	    Solver solver = new Solver(initial);

	    // print solution to standard output
	    if (!solver.isSolvable())
	        StdOut.println("No solution possible");
	    else {
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	            StdOut.println(board);
	    }
	}

}

class HamCom implements Comparator<Board>{

	@Override
	public int compare(Board o1, Board o2) {

		if( o1.move + o1.hamming() < o2.move + o2.hamming()  )
			return -1;
		else
			return 1;
	}
	
}

class ManCom implements Comparator<Board>{

	@Override
	public int compare(Board o1, Board o2) {

		if( o1.move + o1.manhattan() < o2.move + o2.manhattan()  )
			return -1;
		else
			return 1;
	}
	
}
