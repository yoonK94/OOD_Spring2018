package hw8;

import java.util.List;

public class Bullish implements StockAnalyst{
	
	public StockInfo s;
	
	public Bullish(StockInfo s) {
		this.s = s;
	}
	
	public double confidenceLevel() {
		return 0.7;
	}
	
	public String reasons() {
		return "I think the market is going up.\n";
	}
	
	public List<String> getInfo(String key){
		return s.getInfo(key);
	}
}