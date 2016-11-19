import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

/**
 * @author HOON
 * @date   2016. 11. 18.
 */
public class KdTree {
	
	private Node root;
	private int size;
	private Queue<Point2D> q ;
	private Point2D nearest ;

	private static class Node {
		 Point2D p; 		// the point
		private RectHV rect; 	// the axis-aligned rectangle corresponding to this node
		private Node lb; // the left/bottom subtree
		private Node rt; // the right/top subtree
		
	}
	
	public KdTree() {
		// construct an empty set of points
		root = new Node();
		root.rect = new RectHV(0, 0, 1, 1);
		
		size = 0;
	}

	public boolean isEmpty() {
		// is the set empty?
		
		return root.p == null;
	}

	public int size() {
		// number of points in the set
		
		return size;
	}

	public void insert(Point2D p) {
		// add the point to the set (if it is not already in the set)
		if( p == null)
			throw new NullPointerException();
		
		if(contains(p) )
			return;
		
		size++;
		
		if(root.p == null)
			root.p = p;
		else{
			
			insertV(root, p);
			
		}
		
	}
	
	private void insertV(Node n, Point2D p){
		
		if (p.x() < n.p.x()  ){
			
			if(n.lb == null){
				Node newNode = new Node();
				newNode.p = p;
				newNode.rect = new RectHV(n.rect.xmin(), n.rect.ymin()
						, n.p.x(), n.rect.ymax());
				newNode.lb = null;
				newNode.rt = null;
				
				
				n.lb = newNode;
				
				
				return;
			}
			
			insertP(n.lb, p);
		}
		else{
			
			if(n.rt == null){
				Node newNode = new Node();
				newNode.p = p;
				newNode.rect = new RectHV(n.p.x(), n.rect.ymin()
						, n.rect.xmax(), n.rect.ymax());
				newNode.lb = null;
				newNode.rt = null;
				
				n.rt = newNode;
				
				return;
			}
			
			insertP(n.rt, p);
		}
			
		
	}
	
	private void insertP(Node n, Point2D p){
		
		if (p.y() < n.p.y()  ){
			
			if(n.lb == null){
				Node newNode = new Node();
				newNode.p = p;
				newNode.rect = new RectHV(n.rect.xmin(), n.rect.ymin()
						, n.rect.xmax(), n.p.y());
				newNode.lb = null;
				newNode.rt = null;
				
				n.lb = newNode;
				return;
			}else
				insertV(n.lb, p);
		}
			
		else{
			
			if(n.rt == null){
				Node newNode = new Node();
				newNode.p = p;
				newNode.rect = new RectHV(n.rect.xmin(), n.p.y()
						, n.rect.xmax(), n.rect.ymax());
				newNode.lb = null;
				newNode.rt = null;
				
				n.rt = newNode;
				return;
			}else
				insertV(n.rt, p);
		}
			
		
	}

	public boolean contains(Point2D p) {
		// does the set contain point p?
		if( p == null)
			throw new NullPointerException();
		if(root.p != null)
			return containsV(root, p);
		else
			return false;
	}
	
	private boolean containsV(Node n, Point2D p){
		
		if(n == null)
			return false;
		
		if(n.p.equals(p))
			return true;
		
		if(n.p.x() < p.x())
			return containsP(n.lb, p);
		else
			return containsP(n.rt, p);
		
	}
	
	private boolean containsP(Node n, Point2D p){
		
		if(n == null)
			return false;
		
		if(n.p.equals(p))
			return true;
		
		if(n.p.y() < p.y())
			return containsV(n.lb, p);
		else
			return containsV(n.rt, p);
	}

	public void draw() {
		// draw all points to standard draw
		
		if(root.p != null)
			drawV(root);
		
	}
	private void drawV(Node n){
		
		if(n == null)
			return;
		else{
			
			StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.01);
	        n.p.draw();
	        
	        StdDraw.setPenColor(StdDraw.RED);
	        StdDraw.setPenRadius();
	        StdDraw.line(n.p.x(), n.rect.ymin(), n.p.x(), n.rect.ymax());
//	        n.rect.draw();
	        
	        drawP(n.lb);
	        drawP(n.rt);
		}
	}
	private void drawP(Node n){
		
		if(n == null)
			return;
		else{
			
			StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.setPenRadius(0.01);
	        n.p.draw();
	        
	        StdDraw.setPenColor(StdDraw.BLUE);
	        StdDraw.setPenRadius();
	        StdDraw.line(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.p.y());
//	        n.rect.draw();
	        
	        drawV(n.lb);
	        drawV(n.rt);
		}
		
	}
	

	public Iterable<Point2D> range(RectHV rect) {
		// all points that are inside the rectangle
		if( rect == null)
			throw new NullPointerException();
		
		
		q = new LinkedList<Point2D>();
		
		if(root.p != null){
			
			range(root, rect, q);
		}
		
		return q;
	}
	
	private void range(Node n, RectHV rect, Queue<Point2D> q){
		
		if(rect.contains(n.p))
			q.add(n.p);
		
		if( n.lb != null && rect.intersects(n.lb.rect))
			range(n.lb, rect, q);
		
		if(n.rt != null && rect.intersects(n.rt.rect))
			range(n.rt, rect, q);
	}
	

	public Point2D nearest(Point2D p) {
		// a nearest neighbor in the set to point p; null if the set is empty
		if( p == null)
			throw new NullPointerException();
		
		nearest = null;
		
		if(root.p != null){
			nearest = root.p;
			nearest = nearest(p, nearest, root);
		}
			
		
		return nearest;
	}
	
	private Point2D nearest(Point2D p, Point2D nearest, Node n){
		
		if(n == null)
			return nearest;
		
		if(n.p.distanceTo(p) < nearest.distanceTo(p))
			nearest = n.p;
		
		nearest = nearest(p, nearest, n.lb);
		nearest = nearest(p, nearest, n.rt);
		
		
		return nearest;
	}
	
	private Point2D nearestV(Point2D p, Point2D nearest, Node n){
		
		if(n == null)
			return nearest;
		
		if( n.p.distanceSquaredTo(p) < nearest.distanceTo(p))
			nearest = n.p;
		
		if( p.x() < n.p.x()){
			
			nearest = nearestP(p, nearest, n.lb);
			
			if( nearest.distanceTo(p)  >  Math.abs(  p.x() - n.p.x()  )  )
				nearest =	nearestP(p, nearest, n.rt);
		}else{
			
			nearest = nearestP(p, nearest, n.rt);
			
			if( nearest.distanceTo(p)  >  Math.abs(  p.x() - n.p.x()  )  )
				nearest = nearestP(p, nearest, n.lb);
		}
		
		return nearest;
	}
	
	private Point2D nearestP(Point2D p, Point2D nearest, Node n){
		
		if(n == null)
			return nearest;
		
		if( n.p.distanceSquaredTo(p) < nearest.distanceTo(p))
			nearest = n.p;
		
		if( p.y() < n.p.y()){
			
			nearest = nearestP(p, nearest, n.lb);
			if( nearest.distanceTo(p)  >  Math.abs(  p.y() - n.p.y()  )  )
				nearest = nearestP(p, nearest, n.rt);
			
		}else{
			
			nearest = nearestP(p, nearest, n.rt);
			
			if( nearest.distanceTo(p)  >  Math.abs(  p.y() - n.p.y()  )  )
				nearest = nearestP(p, nearest, n.lb);
		}
		
		return nearest;
		
	}
	
	

//	public static void main(String[] args) // unit testing of the methods
//											// (optional)
//	{
//		// TODO Auto-generated method stub
//	}

}
