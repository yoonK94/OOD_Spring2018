package hw7;

import java.util.*;

public class SortedCollection<T> extends AbstractCollection<T>{
	private Collection<T> result;
	
	public SortedCollection(Collection<T> c, Comparator<T> comp) {
		result = sort(c, comp);
	}
	
	public int size() {
		return result.size();
	}
	
	public Iterator<T> iterator(){
		return result.iterator();
	}
	
	private Collection<T> sort(Collection<T> c, Comparator<T> comp){
		boolean done = false;
		Collection<T> result = c;
		Collection<T> c1 = new ArrayList<>(); 
		Collection<T> c2 = new ArrayList<>();
		boolean alter;
		LookAheadIterator<T> current;
		T val;
		
		while(!done) {
			current = new LookAheadIterator<T>(result.iterator());
			alter = true;
			val = current.hasNext()? current.peek():null;
			
			while(current.hasNext()) {
				if(comp.compare(current.peek(), val) < 0) {
					alter = !alter;
				}
				val = current.next();
				if(alter)
					c1.add(val);
				else
					c2.add(val);
			}
			
			if(c2.isEmpty())
				return c1;
			else {
				result = new MergedCollection<>(c1, c2, comp);
				c1 = new ArrayList<>();
				c2 = new ArrayList<>();
			}
		}
		return c;
		}
}
