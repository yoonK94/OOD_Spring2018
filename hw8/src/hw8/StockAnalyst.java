package hw8;

import java.util.*;

public interface StockAnalyst {
	public double confidenceLevel();
	public String reasons();
	public List<String> getInfo(String key);
}
