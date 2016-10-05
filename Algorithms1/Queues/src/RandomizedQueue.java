import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author HOON
 * @date   2016. 10. 4.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	
	/**
	 * Try to use array
	 */
	private Item[] rq ;
	private int size;
	
	public RandomizedQueue() {
		
		// UGLY CAST!
		rq = (Item[]) new Object[2];
		size = -1;
	}
	
	public boolean isEmpty() {
		
		return size == -1;
	}
	public int size() {
		return size+1;
	}
	public void enqueue(Item item) {
		
		if(item == null)
			throw new NullPointerException ("euque : Input proper item");
		
		rq[++size] = item;
		
		// size up if RanmodizedQueue is full
		if(size == rq.length-1){
			Item[] tmp = (Item[]) new Object[rq.length*2];
			
			for(int i = 0 ;  i < rq.length ; i++ ) {
				tmp[i] = rq[i];
			}
			rq = tmp;
		}
	}
	public Item dequeue() {
		
		if(isEmpty())
			throw new NoSuchElementException("dequeue : RandomizedQueue is empty");
		
		int random = StdRandom.uniform(size+1);
		Item itmp = rq [ random ];
		
		for(int i = random ; i < size ; i++ ){
			rq[i] = rq[ i+1 ];
		}
		
		size--;
		
		// resizing
		if(size < rq.length/4){
			
			Item[] tmp = (Item[]) new Object[rq.length/2];
			
			for(int i = 0 ;  i < size+1 ; i++ ) {
				tmp[i] = rq[i];
			}
			rq = tmp;
		}
		
		
		return itmp;
	}
	public Item sample() {
		
		if(isEmpty())
			throw new NoSuchElementException("dequeue : RandomizedQueue is empty");
		
		return rq[ StdRandom.uniform(size+1) ];
	}
	

	public static void main(String[] args) {

		
	}
	
	@Override
	public Iterator<Item> iterator() {
		if(rq == null){
			throw new IndexOutOfBoundsException();
		}
		
		return new RQIterator();
	}
	private class RQIterator implements Iterator<Item> {
		
		private int n = size;
		
		private RQIterator(){
			StdRandom.shuffle(rq, 0, size);
		}
		
		@Override
		public boolean hasNext() {
			
			return n >= 0;
		}

		@Override
		public Item next() {
			
			if(!hasNext())
				throw new NoSuchElementException("next : RandomizedQueue is Empty");
		
			
			return rq[n--];
		}
		
		public void remove(){
				throw new UnsupportedOperationException ("Don't use remove() method");
		}
	}

}
