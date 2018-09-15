package hw7;

import java.util.*;

public class MergedIterator<T> implements Iterator<T> {
   private LookAheadIterator<T> i1, i2;
   private Comparator<T> comp;
   private T past;
   
   public MergedIterator(Iterator<T> iter1, Iterator<T> iter2, Comparator<T> comp) {
      i1 = new LookAheadIterator<T>(iter1);
      i2 = new LookAheadIterator<T>(iter2);
      this.comp = comp;
      past = (comp.compare(i1.peek(), i2.peek()) < 0)? i1.peek(): i2.peek();
   }
   
   public boolean hasNext() {
      return i1.hasNext() || i2.hasNext();
   }
   
   public T next() {
      T result;
      
      if (!i1.hasNext()) 
    	  result = i2.next();
	  else if (!i2.hasNext()) 
		  result = i1.next();
	  else if(comp.compare(i1.peek(), past)< 0 && comp.compare(i2.peek(), past)< 0)
		  result = (comp.compare(i1.peek(), i2.peek()) < 0)? i1.next(): i2.next();
	  else if(comp.compare(i1.peek(), past) < 0)	 
		  result = i2.next(); 
	  else if(comp.compare(i2.peek(), past) < 0)
		  result = i1.next();
	  else if (comp.compare(i1.peek(), i2.peek()) < 0)
		  result = i1.next();
	  else
		  result = i2.next();
      past = result;
      return result;  
   }
}
