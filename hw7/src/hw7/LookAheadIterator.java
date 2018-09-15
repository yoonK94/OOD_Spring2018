package hw7;

import java.util.*;

public class LookAheadIterator<T> implements Iterator<T> {
	
	private Iterator<T> iter;
	private T current;
	
	public LookAheadIterator(Iterator<T> iter) {
		this.iter = iter;
		current = iter.hasNext()? iter.next() : null;
	}
	
	public boolean hasNext() {
		return current != null;
	}
	
	public T next() {
		T cur = current;
		current = iter.hasNext()? iter.next():null;
		return cur;
	}
	
	public T peek() {
		return current;
	}
}
