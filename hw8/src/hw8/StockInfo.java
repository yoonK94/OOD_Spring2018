package hw8;

import java.io.*;
import java.util.*;

public class StockInfo {
	
	private Map<String, List<String>> sInfo;
	
	public StockInfo(String fName) {
		Scanner sc = null;
		sInfo = new HashMap<String, List<String>>();
	    try {
	        sc = new Scanner(new File(fName));
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    while (sc.hasNextLine()) {
	        Scanner s2 = new Scanner(sc.nextLine());
	        if(s2.hasNext()) {
	        	String category = s2.next();
	        	List<String> values = new ArrayList<String>();
		        while (s2.hasNext()) {
		            values.add(s2.next());
		        }
		        sInfo.put(category, values);
	        }
	        s2.close();
	    }
	    sc.close();
	}
	
	public List<String> getInfo(String key){
		return sInfo.get(key);
	}
	
}
