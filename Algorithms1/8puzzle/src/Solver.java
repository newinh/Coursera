import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author HOON
 * @date   2016. 11. 2.
 */
public class Solver {
	
	private Board initial;
	
	private MinPQ<SearchNode> pq;
	private MinPQ<SearchNode> pq_t;
	
	private class SearchNode implements Comparable<SearchNode>{
		
		Board board;
		int moves;
		int priority;
		SearchNode previousNode;
		
		SearchNode(Board b, int m, SearchNode pre){
			board = b;
			moves = m;
			priority = moves + b.manhattan();
			previousNode = pre;
		}

		@Override
		public int compareTo(SearchNode o) {
			return (this.priority - o.priority);
		}
		
	}
	
	
	public Solver(Board initial){
		
		if(initial == null)
			throw new java.lang.NullPointerException();
		
		this.initial = initial;
		
		SearchNode node;
		SearchNode node_t;
		
		pq = new MinPQ<SearchNode>();
		pq_t = new MinPQ<SearchNode>();
		
		
		pq.insert(new SearchNode(initial, 0, null));
		pq_t.insert(new SearchNode(initial.twin(), 0, null));
		
		
		
		
		while( !pq.min().board.isGoal()  && !pq_t.min().board.isGoal() ){
			
			node = pq.delMin();
			
			for(Board b : node.board.neighbors()){
				
				if(node.moves != 0)
				if(b.equals(node.previousNode.board))
					continue;
				
				pq.insert(new SearchNode(b, node.moves+1, node));
				
			}
			
			
			node_t = pq_t.delMin();
			
			for(Board b : node_t.board.neighbors()){
				
				if(node_t.moves != 0)
				if(b.equals(node_t.previousNode.board))
					continue;
				pq_t.insert(new SearchNode(b, node_t.moves+1, node_t));
				
			}
			
		}
		
	}
	
	public boolean isSolvable(){
		
		if(pq.min().board.isGoal())
			return true;
		else
			return false;
	}
	
	public int moves(){
		if(isSolvable())
			return pq.min().moves;
		else
			return -1;
	}
	
	public Iterable<Board> solution(){
		
		
		if(!isSolvable())
			return null;
		
		Stack<Board> stack = new Stack<Board>();
		
		SearchNode a = pq.min().previousNode;
		
		while(a.previousNode != null){
			
			stack.push(a.board);
			a = a.previousNode;
			
		}
		stack.push(initial);
		
		return stack;
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
