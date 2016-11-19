import java.util.Iterator;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author HOON
 * @date   2016. 11. 18.
 */
public class PointSET {
	
	private TreeSet<Point2D> set;
	private int size;

	public PointSET() {
		// construct an empty set of points
		set = new TreeSet<Point2D>();
		size = 0;
	}

	public boolean isEmpty() {
		// is the set empty?
		return set.isEmpty();
	}

	public int size() {
		// number of points in the set
		
		return size;
	}

	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		
		if( p == null)
			throw new NullPointerException();
		
		if(!set.contains(p)){
			set.add(p);
			size++;
		}
		
	}

	public boolean contains(Point2D p) {
		// does the set contain point p?
		if( p == null)
			throw new NullPointerException();
		
		
		return set.contains(p);
	}

	public void draw() {
		// draw all points to standard draw
		
//		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        
        Iterator<Point2D> it = set.iterator();
        Point2D p ;

        while(it.hasNext()){
        	p = it.next();
        	StdDraw.point(p.x(), p.y());
        }
		
//          StdDraw.show();		
	}

	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle
		if( rect == null)
			throw new NullPointerException();
		
		TreeSet<Point2D> inSet = new TreeSet<Point2D>();
		
		
		Iterator<Point2D> it = set.iterator();
        Point2D p ;

        while(it.hasNext()){
        	p = it.next();
        	
        	if(rect.contains(p))
        		inSet.add(p);
        	
        }
		return inSet;
	}

	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p; null if the set is empty
		if( p == null)
			throw new NullPointerException();
		
		Iterator<Point2D> it = set.iterator();
        Point2D x;
        double min = 1.5;
        Point2D nearest = null;

        while(it.hasNext()){
        	x = it.next();
        	
        	if(p.distanceTo(x) < min){
        		min = p.distanceTo(x);
        		nearest = x;
        	}
        }
		
		
		return nearest;
	}

//	public static void main(String[] args) // unit testing of the methods
//											// (optional)
//	{
//		// TODO Auto-generated method stub
//
//	}

}
