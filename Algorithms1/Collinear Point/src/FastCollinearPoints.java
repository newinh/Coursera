import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
	
	private java.util.ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
	
	public FastCollinearPoints(Point[] points){
		
		if(points == null)
			throw new NullPointerException();
		
		int size = points.length;
		
		for(int i = 0 ; i < size ; i++){
			if(points[i] == null)
				throw new NullPointerException();
		}
		
		Point[] pointsCopy = Arrays.copyOf(points, size);
		
		Arrays.sort(pointsCopy);
		
		for(int i = 0 ; i < size-1 ; i++){
			if(pointsCopy[i].compareTo(pointsCopy[i+1]) == 0)
				throw new IllegalArgumentException();
		}
		///////////////////////
		
		Arrays.sort(points);
		for(int i = 0 ; i < size ;i++){
			
			Point[] slopeOrderedPoints = Arrays.copyOf(points, size); 
			Arrays.sort(slopeOrderedPoints, points[i].slopeOrder());
			
			for(int j = 0 ; j < size ; ){
				
				int k = j + 1;
				
				while(k < size){
					
					if(points[i].slopeTo(slopeOrderedPoints[j])   !=   points[i].slopeTo(slopeOrderedPoints[k]) )
						break;
					k++;
				}
				
				int count = k - j;
				
				
				if(count >= 3){
					
					if(points[i].compareTo(slopeOrderedPoints[j]) < 0){
						LineSegment tmp = new LineSegment(points[i], slopeOrderedPoints[k-1]) ;
					
					
					if(!segmentsList.contains(tmp))
						segmentsList.add ( tmp);
					}
				}
				
				j = k;
				
			}

			
		}
		
	}
	
	public int numberOfSegments(){
		return segmentsList.size();
	}
	
	public LineSegment[] segments(){
		return segmentsList.toArray(new LineSegment[segmentsList.size()]);
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
		
		
		FastCollinearPoints collinear = new FastCollinearPoints(points);
		for(LineSegment segment : collinear.segments()){
			StdOut.println(segment);
			segment.draw();
		}
		StdDraw.show();
	}

}
