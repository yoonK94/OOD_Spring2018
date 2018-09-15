package hw8;

import java.util.List;

public class Bearish implements StockAnalyst{
	
	public StockInfo s;
	
	public Bearish(StockInfo s) {
		this.s = s;
	}
	
	public double confidenceLevel() {
		return 0.3;
	}
	
	public String reasons() {
		return "I think the market is going down.\n";
	}
	
	public List<String> getInfo(String key){
		return s.getInfo(key);
	}

}