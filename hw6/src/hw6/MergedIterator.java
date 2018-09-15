package hw6;

import java.util.*;


public class MergedIterator<T> implements Iterator<T>{
	private Iterator<T> i1;
	private Iterator<T> i2;
	private Comparator<T> comp;
	private T c1;
	private T c2;
	
	public MergedIterator(Iterator<T> i1, Iterator<T> i2, Comparator<T> comp) {
		this.i1 = i1;
		this.i2 = i2;
		this.comp = comp;
		if(i1.hasNext())	
			this.c1 = i1.next();
		if(i2.hasNext())
			this.c2 = i2.next();
	}
	
	public boolean hasNext() {
		return (c1 != null)||(c2 != null);
	}
	
	public T next() {
		T result;
		
		//Assuming user calls this.hasNext() before calling this.next()
		if(c1 == null) {
			result = c2;
			c2 = i2.hasNext()?i2.next():null;
		}
		else if(c2 == null) {
			result = c1;
			c1 = i1.hasNext()?i1.next():null;
		}
		else {
			if(comp.compare(c1, c2)<= 0) {
				result = c1;
				c1 = i1.hasNext()? i1.next():null; 
			}
			else {
				result = c2;
				c2 = i2.hasNext()? i2.next():null;
			}
		}
		return result;
	}
}
