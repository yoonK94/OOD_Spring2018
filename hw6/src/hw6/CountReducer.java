package hw6;

import java.util.function.*;

public class CountReducer<T> implements Reducer<T, Integer>{
	
	private Predicate<T> pred;
	private int count;
	
	public CountReducer(Predicate<T> pred) {
		this.pred = pred;
		count = 0;
	}
	
	public void accept(T e1) {
		if(pred.test(e1))	count++;			
	}
	
	public Integer result() {
		return count;
	}
}
