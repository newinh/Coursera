import edu.princeton.cs.algs4.*;

public class PercolationStats {

	private Percolation percolation;
	private int[] openRandom;
	private double[] result;
	private int count;
	private int openi;
	private int openj;
	
	private int i;
	private int j;
	
	private final int TRIALS;
	
	public PercolationStats(int n, int trials) {
		
		TRIALS = trials;
		
		validate(n, trials);
		
		openRandom = new int[(n*n) ];
		
		for( i = 0; i < (n*n)  ; i++ )
			openRandom[i] = i;
		
		result = new double[trials];
		
		
		for( j = 0 ; j < trials; j++) {
			
			percolation = new Percolation(n);
			StdRandom.shuffle(openRandom);
			count = 0;
			
			while(!percolation.percolates()) {
				
				openi = openRandom[count] / n;
				openi += 1;
				
				openj = openRandom[count] % n;
				openj +=1 ;
				
				percolation.open(openi, openj);
				count++;
			}
			result[j] = ( (double)count /(n*n) ) ;
		}
		
//		System.out.println(trials + " successed\n");
	}
	
	public double mean() {
		
		return StdStats.mean(result)  ;
	}
	
	public double stddev() {
		return StdStats.stddev(result);
	}
	
	public double confidenceLo() {
		double mean = mean();
		double stddev = stddev();
		double sqrtOfTrials = Math.sqrt(TRIALS);
		
		double tmp;
		
		tmp = stddev*1.96;
		tmp /= sqrtOfTrials;
		tmp = mean - tmp;
				
		return tmp;
	}

	public double confidenceHi() {
		
		double mean = mean();
		double stddev = stddev();
		double sqrtOfTrials = Math.sqrt(TRIALS);
		
		double tmp;
		
		tmp = stddev*1.96;
		tmp /= sqrtOfTrials;
		tmp = mean + tmp;
				
		return tmp;
	}
	
	private void validate(int n, int trials) {
        
        if (n <= 0 ) {
            throw new IndexOutOfBoundsException("n " + n + " must up to 0" );  
        }
        if (trials <= 0) {
            throw new IndexOutOfBoundsException("trials " + trials + " must up to 0" );  
        }
    }
	
	public static void main(String[] args) {

		Stopwatch clock = new Stopwatch();
		
		if (args.length != 2) {
			System.out.println("Input error");
			System.exit(0);
		}
		
		int n = Integer.parseInt(args[0]); 
		int trials = Integer.parseInt(args[1]);
		
		
		PercolationStats percolationStats = new PercolationStats(n, trials);
		
//		System.out.println("n\t\t\t:" + n);
//		System.out.println("trials\t\t\t:" + trials);
		System.out.println("mean\t\t\t:" + percolationStats.mean());
		System.out.println("stddev\t\t\t:" + percolationStats.stddev());
		System.out.println("95% confidence interval\t:" +
		percolationStats.confidenceLo() +", " + percolationStats.confidenceHi());
		
		System.out.println("\n " + clock.elapsedTime() + "seconds"); 
		
		
//		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
		
		

	}

}
