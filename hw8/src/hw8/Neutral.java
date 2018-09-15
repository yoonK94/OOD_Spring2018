package hw8;

import java.util.List;

public class Neutral implements StockAnalyst{
	
	public StockInfo s;
	
	public Neutral(StockInfo s) {
		this.s = s;
	}
	
	public double confidenceLevel() {
		return 0.5;
	}
	
	public String reasons() {
		return "The market's future is unclear.\n";
	}
	
	public List<String> getInfo(String key){
		return s.getInfo(key);
	}

}
