package hw9;

import java.util.*;
import java.util.function.*;

public interface Polynomial {
	String toString();
	boolean equals(Object obj);
	boolean hasNoVariables();
	int evaluate(Map<String,Integer> m);
	Polynomial reduce();
	Iterator<Polynomial> childIterator();
	
	default void forEach(Consumer<Polynomial> c) { 
		c.accept(this);
		Iterator<Polynomial> i = this.childIterator();
		while(i.hasNext()) {
			Polynomial p = i.next();
			p.forEach(c);
		}
	}
}
