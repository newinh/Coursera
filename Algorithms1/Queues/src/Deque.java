import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author HOON
 * @date   2016. 10. 4.
 */


public class Deque<Item> implements Iterable<Item>{
	
	
	/**
	 *	Try to List!
	 */
	
	private Node first, last;
	private int size;
	
	// This node have 2-way
	private class Node{
		
		Node next;
		Node pre;
		Item item;
		
		private Node(Item item){
			this.item = item;
		}
	}
	public Deque() {
		first = new Node(null);
		last = new Node(null);
		
		first.next = last;
		last.pre = first;
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0
				|| first.next == last
				|| last.pre == first;
	}
	public int size(){
		return this.size;
	}
	public void addFirst(Item item){
		
		if(item == null)
			throw new NullPointerException ("addFirst : Input proper item");
		
		Node newNode = new Node(item);
		
		newNode.next = first.next;
		newNode.pre = first;
		
		first.next.pre = newNode;
		first.next = newNode;
		size++;
		
	}
	public void addLast(Item item){
		
		if(item == null)
			throw new NullPointerException ("addLast: Input proper item");
		
		Node newNode = new Node(item);
		
		newNode.next = last;
		newNode.pre  = last.pre;
		
		last.pre.next = newNode;
		last.pre = newNode;
		size++;
		
	}
	public Item removeFirst() {
		
		if(isEmpty())
			throw new NoSuchElementException  ("removeFirst: Deque is Empty");
		
		Item returnItem = first.next.item;
		
		first.next.pre = null ;
		first.next = first.next.next;
		first.next.pre.next = null;
		first.next.pre = first;
		
		size--;
		
		return returnItem;
		
	}
	public Item removeLast() {
		
		if(isEmpty())
			throw new NoSuchElementException  ("removeLast: Deque is Empty");
		
		Item returnItem = last.pre.item;
		
		last.pre.next = null;
		last.pre = last.pre.pre;
		last.pre.next.pre = null;
		last.pre.next = last;
		
		size--;
		return returnItem;
	}

	public static void main(String[] args) {
		

	}
	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	private class DequeIterator implements Iterator<Item>{
		
		private int n = size;
		private Node p = first;

		@Override
		public boolean hasNext() {
			return n > 0;
		}

		@Override
		public Item next() {
			
			if(!hasNext())
				throw new NoSuchElementException("next : Deque is Empty");
			n--;
			p = p.next;
			
			return p.item;
		}
		
		public void remove(){
			throw new UnsupportedOperationException ("Don't use remove() method"); 
		}
		
	}

}
