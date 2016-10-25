import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
	
	private java.util.ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
	
	public BruteCollinearPoints(Point[] points) {
		
		if(points == null)
			throw new NullPointerException();
		
		int size = points.length;
		
		for(int i = 0 ; i < size ; i++){
			if(points[i] == null)
				throw new NullPointerException();
		}
		
		Arrays.sort(points);
		
		for(int i = 0 ; i < size-1 ; i++){
			
			if(points[i].compareTo(points[i+1]) == 0)
				throw new IllegalArgumentException();
			
		}
		
		
		for(int i = 0 ; i < size ; i++){
			
			for(int j = i+1 ; j < size ; j++){
				
				for(int k = j+1 ; k < size ; k++){
					
					for(int l = k+1 ; l < size ; l ++){
						
						
						if( points[i].slopeTo(points[j]) == points[j].slopeTo(points[k]) &&
								points[j].slopeTo(points[k]) == points[k].slopeTo(points[l]) ){
							
							LineSegment tmp = new LineSegment(points[i], points[l]) ;
							
							if(!segmentsList.contains(tmp))
								segmentsList.add ( tmp);
						}
					}
				}
			}
		}
	}
	
	public int numberOfSegments(){
		return segmentsList.size();
	}
	
	public LineSegment[] segments(){
		
		LineSegment[] lineSegments ;
		
		lineSegments = segmentsList.toArray(new LineSegment[segmentsList.size()]);
		
		return lineSegments;
		
	}

	public static void main(String[] args) {
		
		In in = new In(args[0]);
		int n = in.readInt();
		
		Point[] points = new Point[n];
		
		for(int i = 0 ; i < n ; ++i){
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		
		for(Point p : points){
			p.draw();
		}
		StdDraw.show();
		
		
		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		for(LineSegment segment : collinear.segments()){
			StdOut.println(segment);
			segment.draw();
		}
		StdDraw.show();
	}

}
