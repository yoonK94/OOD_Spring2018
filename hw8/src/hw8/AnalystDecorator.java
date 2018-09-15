package hw8;

import java.util.*;

public abstract class AnalystDecorator implements StockAnalyst{
	
	protected StockAnalyst a;
	protected double current;
	protected boolean nonInfo = false;
	
	protected AnalystDecorator(StockAnalyst a) {
		this.a = a;
		current = 0;
	}
	
	public List<String> getInfo(String key){
		return a.getInfo(key);
	}
	
	public abstract double confidenceLevel();
	
	public abstract String reasons();

}