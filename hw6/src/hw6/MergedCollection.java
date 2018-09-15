package hw6;

import java.util.*;

public class MergedCollection<T> extends AbstractCollection<T>{
	private Collection<T> c1;
	private Collection<T> c2;
	private Comparator<T> comp;
	
	public MergedCollection(Collection<T> c1, Collection<T> c2, Comparator<T> comp) {
		this.c1 = c1;
		this.c2 = c2;
		this.comp = comp;
	}
	
	public Iterator<T> iterator(){
		return new MergedIterator<T>(c1.iterator(), c2.iterator(), comp);
	}
	
	public int size() {
		return c1.size() + c2.size();
	}
}
