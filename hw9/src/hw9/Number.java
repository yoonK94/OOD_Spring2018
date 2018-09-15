package hw9;

import java.util.*;

public class Number implements Polynomial{
	
	private int val;
	
	public Number(int val) {
		this.val = val;
	}
	
	public String toString() {
		return Integer.toString(val);
	}
	
	
	public boolean equals(Object obj) {
		if (obj instanceof Number)
			return val == ((Number) obj).evaluate(null);
		return false;
	}
	
	
	public boolean hasNoVariables() {
		return true;
	}
	
	
	public int evaluate(Map<String,Integer> m) {
		return val;
	}
	
	public Polynomial reduce() {
		return new Number(val);
	}
	
	public Iterator<Polynomial> childIterator(){
		List<Polynomial> l = new ArrayList<>();
		return l.iterator();
	}
	
}
