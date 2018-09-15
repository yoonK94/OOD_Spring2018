package hw9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Variable implements Polynomial, Comparable<Variable>{
	
	private String val;
	
	public Variable(String val) {
		this.val = val;
	}
	
	public String toString() {
		return val;
	}
	
	
	public boolean equals(Object obj) {
		if(obj instanceof Variable)
			return val.equals(((Variable) obj).toString());
		return false;
	}
	
	public boolean hasNoVariables() {
		return false;
	}
	
	public int evaluate(Map<String,Integer> m) {
		if(m.containsKey(val))
			return m.get(val);
		else
			throw new NullPointerException("There is no value assigned for " + val);
	}
	
	public Polynomial reduce() {
		return new Variable(val);
	}
	
	public Iterator<Polynomial> childIterator(){
		List<Polynomial> l = new ArrayList<>();
		return l.iterator();
	}
	
	public int compareTo(Variable v) {
		return val.compareTo(v.toString());
	}
}
